package ru.otus.library.service;

import ru.otus.library.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
  void insertGenre(String name) ;
  Optional<Genre> readeGenreById(long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(long id);
}
