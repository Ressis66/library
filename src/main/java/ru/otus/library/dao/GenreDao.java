package ru.otus.library.dao;

import ru.otus.library.domain.Genre;

import java.util.List;

public interface GenreDao {
  void insertGenre(String name) ;
  Genre readeGenreById(long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(long id);
}
