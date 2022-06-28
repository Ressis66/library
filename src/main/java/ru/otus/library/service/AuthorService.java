package ru.otus.library.service;

import ru.otus.library.domain.Author;

import java.util.List;

public interface AuthorService {
  void insertAuthor(String name);
  Author readeAuthorById(long id);
  List<Author> readeAllAuthors();
  void deleteAuthorById(long id);
}
