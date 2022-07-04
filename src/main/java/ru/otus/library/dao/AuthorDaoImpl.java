package ru.otus.library.dao;


import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.otus.library.domain.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoImpl implements AuthorDao {

  private final NamedParameterJdbcOperations jdbcOperations;
  private final JdbcOperations jdbcTemplate;

  public AuthorDaoImpl(NamedParameterJdbcOperations jdbcOperations, JdbcOperations jdbcTemplate) {
    this.jdbcOperations = jdbcOperations;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertAuthor(String name) {
    String sql = "insert into authors (name) values (?)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(
        connection -> {
          PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
          ps.setString(1, name);
          return ps;
        }, keyHolder);

  }

  @Override
  public Author readeAuthorById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    return jdbcOperations.queryForObject(
        "select id, name from authors where id = :id", params, new AuthorMapper());
  }

  @Override
  public List<Author> readeAllAuthors() {
    return jdbcOperations.query("select id, name from authors", new AuthorMapper());
  }

  @Override
  public void deleteAuthorById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    jdbcOperations.update(
        "delete from authors where id = :id", params
    );
  }

  private static class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      return new Author(id, name);
    }
  }
}

