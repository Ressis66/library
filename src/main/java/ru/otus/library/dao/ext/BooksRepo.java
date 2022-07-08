package ru.otus.library.dao.ext;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.otus.library.domain.Author;
import ru.otus.library.domain.Book;
import ru.otus.library.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BooksRepo implements
    ResultSetExtractor<Map<Long, Book>> {

  public Map<Long, Book> extractData(ResultSet rs) throws SQLException,
      DataAccessException {

    Map<Long, Book> books = new HashMap<>();
    while (rs.next()) {
      long id = rs.getLong("id");
      Book book = books.get(id);
      if (book == null) {
        book = new Book(id, rs.getString("name"),
                        new Author(rs.getString("authors_name")),
                        new Genre(rs.getString("genres_name")));
        books.put(book.getId(), book);
      }


    }
    return books;
  }
}

