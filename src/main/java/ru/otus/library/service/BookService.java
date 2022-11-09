package ru.otus.library.service;

import ru.otus.library.domain.Book;
import ru.otus.library.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface BookService {
  void insertBook (Book book);
  Book readeBookById(long id);
  List<Book> readeAllBooks();
  void deleteBookById(long id);
  void insertComment(Comment comment);
}
