package ru.otus.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dao.BookDao;
import ru.otus.library.domain.Book;
import ru.otus.library.domain.Comment;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class BookServiceImpl implements BookService {

  private BookDao bookDao;

  public BookServiceImpl(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  @Override
  public  void insertBook(Book book) {
    bookDao.insertBook(book);
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

  @Override
  public  void insertComment(Comment comment){
    bookDao.insertComment(comment);
  }


}
