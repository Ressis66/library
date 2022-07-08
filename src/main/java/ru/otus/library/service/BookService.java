package ru.otus.library.service;

import ru.otus.library.domain.Book;

import java.util.List;

public interface BookService {
  void insertBook (String name, long genre_id, long author_id);
  Book readeBookById(long id);
  List<Book> readeAllBooks();
  void deleteBookById(long id);
}