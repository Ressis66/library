package ru.otus.library.dao;

import ru.otus.library.domain.Book;
import ru.otus.library.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface BookDao {
  void insertBook(Book book);
  Book readeBookById(Long id);
  List<Book> readeAllBooks();
  void deleteBookById(Long id);
  void insertComment(Comment comment);
}

