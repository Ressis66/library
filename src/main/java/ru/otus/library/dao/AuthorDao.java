package ru.otus.library.dao;

import ru.otus.library.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
  void insertAuthor(String name);
  Optional <Author> readeAuthorById(Long id);
  List<Author> readeAllAuthors();
  void deleteAuthorById(Long id);
}
