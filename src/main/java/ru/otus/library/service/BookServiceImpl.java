package ru.otus.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library.dao.BookDao;
import ru.otus.library.domain.Book;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Override
  public void insertBook(String name, long genre_id, long author_id) {
    bookDao.insertBook(name, genre_id, author_id);
  }

  @Override
  public Book readeBookById(long id) {
    return bookDao.readeBookById(id);
  }

  @Override
  public List<Book> readeAllBooks() {
    return bookDao.readeAllBooks();
  }

  @Override
  public void deleteBookById(long id) {
    bookDao.deleteBookById(id);
  }
}
