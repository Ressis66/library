package ru.otus.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library.dao.AuthorDao;
import ru.otus.library.domain.Author;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService{

  @Autowired
  private AuthorDao authorDao;

  @Override
  public void insertAuthor(String name) {
    authorDao.insertAuthor(name);
  }

  @Override
  public Author readeAuthorById(long id) {
    return authorDao.readeAuthorById(id);
  }

  @Override
  public List<Author> readeAllAuthors() {
    return authorDao.readeAllAuthors();
  }

  @Override
  public void deleteAuthorById(long id) {
    authorDao.deleteAuthorById(id);
  }
}