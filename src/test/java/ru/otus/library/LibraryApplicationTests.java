package ru.otus.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import org.springframework.context.annotation.Import;
import ru.otus.library.dao.AuthorDaoImpl;
import ru.otus.library.dao.BookDaoImpl;
import ru.otus.library.dao.GenreDaoImpl;


@JdbcTest
@Import({AuthorDaoImpl.class, BookDaoImpl.class, GenreDaoImpl.class})
public class LibraryApplicationTests {

  @Autowired
  private AuthorDaoImpl authorService;

  @Autowired
  private BookDaoImpl bookService;

  @Autowired
  private GenreDaoImpl genreService;

  @Test
  void shouldReturnCorrectAuthorsListWithAllInfo() {
    Assertions.assertNotNull(authorService.readeAllAuthors());
  }

  @Test
  void shouldReturnCorrectBooksListWithAllInfo() {
    Assertions.assertNotNull(bookService.readeAllBooks());
  }

  @Test
  void shouldReturnCorrectGenresListWithAllInfo() {
    Assertions.assertNotNull(genreService.readeAllGenres());
  }
}