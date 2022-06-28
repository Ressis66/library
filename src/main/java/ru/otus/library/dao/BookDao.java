package ru.otus.library.dao;

import ru.otus.library.domain.Book;

import java.util.List;

public interface BookDao {
  void insertBook(String name, long genre_id, long author_id);
  Book readeBookById(long id);
  List<Book> readeAllBooks();
  void deleteBookById(long id);
}
