package ru.otus.library.dao;

import ru.otus.library.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {
  void insertGenre(String name) ;
  Optional<Genre> readeGenreById(Long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(Long id);
}
