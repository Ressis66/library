package ru.otus.library.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.otus.library.dao.ext.BooksRepo;
import ru.otus.library.domain.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class BookDaoImpl implements BookDao {

  private final NamedParameterJdbcOperations jdbcOperations;
  private JdbcOperations jdbcTemplate;


  public BookDaoImpl(NamedParameterJdbcOperations jdbcOperations, JdbcOperations jdbcTemplate) {
    this.jdbcOperations = jdbcOperations;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertBook(String name, long genre_id, long author_id) {
    String sql = "insert into books (name, genre_id, author_id) values (?, ?, ?)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(
        connection -> {
          PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
          ps.setString(1, name);
          ps.setLong(2, genre_id);
          ps.setLong(3, author_id);
          return ps;
        }, keyHolder);

  }

  @Override
  public Book readeBookById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    return jdbcOperations.queryForObject(
        "select id, name from books where id = :id", params, new BookMapper());
  }

  @Override
  public List<Book> readeAllBooks() {
    Map<Long, Book> books = jdbcOperations.query("select books.id, books.name " +
                "from books", new BooksRepo());

      return new ArrayList<>(Objects.requireNonNull(books).values());
  }

  @Override
  public void deleteBookById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    jdbcOperations.update(
        "delete from books where id = :id", params
    );
  }

  private static class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      return new Book(id, name);
    }
  }
}
