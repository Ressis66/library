package ru.otus.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dao.GenreDao;
import ru.otus.library.domain.Genre;

import java.util.List;

@Component
public class GenreServiceImpl implements  GenreService{

  @Autowired
  private GenreDao genreDao;

  @Override
  public void insertGenre(String name) {
    genreDao.insertGenre(name);
  }

  @Override
  public Genre readeGenreById(long id) {
    return genreDao.readeGenreById(id);
  }

  @Override
  public List<Genre> readeAllGenres() {
    return genreDao.readeAllGenres();
  }

  @Override
  public void deleteGenreById(long id) {
    genreDao.deleteGenreById(id);
  }
}