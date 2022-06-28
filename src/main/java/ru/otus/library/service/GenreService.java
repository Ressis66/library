package ru.otus.library.service;

import ru.otus.library.domain.Genre;

import java.util.List;

public interface GenreService {
  void insertGenre(String name) ;
  Genre readeGenreById(long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(long id);
}
