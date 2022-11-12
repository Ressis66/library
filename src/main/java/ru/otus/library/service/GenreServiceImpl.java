package ru.otus.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library.dao.GenreDao;
import ru.otus.library.domain.Genre;

import java.util.List;
import java.util.Optional;

@Component
public class GenreServiceImpl implements  GenreService{

  private GenreDao genreDao;

  public GenreServiceImpl(GenreDao genreDao) {
    this.genreDao = genreDao;
  }

  @Override
  public void insertGenre(String name) {
    genreDao.insertGenre(name);
  }

  @Override
  public Optional<Genre> readeGenreById(long id) {
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
