package ru.otus.library.service;

import ru.otus.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
  void insertBook (Book book);
  Optional<Book> readeBookById(long id);
  List<Book> readeAllBooks();
  void deleteBookById(long id);
}
