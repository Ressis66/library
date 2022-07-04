package ru.otus.library.dao;


import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.otus.library.domain.Genre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoImpl implements GenreDao{

  private final NamedParameterJdbcOperations jdbcOperations;
  private JdbcOperations jdbcTemplate;

  public GenreDaoImpl(NamedParameterJdbcOperations jdbcOperations, JdbcOperations jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.jdbcOperations = jdbcOperations;
  }

  @Override
  public void insertGenre(String name) {
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
  public Genre readeGenreById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    return jdbcOperations.queryForObject(
        "select id, name from genres where id = :id", params, new GenreMapper());
  }

  @Override
  public List<Genre> readeAllGenres() {
    return jdbcOperations.query("select id, name from genres", new GenreMapper());
  }

  @Override
  public void deleteGenreById(long id) {
    Map<String, Object> params = Collections.singletonMap("id", id);
    jdbcOperations.update(
        "delete from genres where id = :id", params
    );
  }
  private static class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      return new Genre(id, name);
    }
  }
}
