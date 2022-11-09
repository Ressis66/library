package ru.otus.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.domain.Book;
import ru.otus.library.domain.Comment;
import ru.otus.library.service.AuthorService;
import ru.otus.library.service.BookService;
import ru.otus.library.service.GenreService;
import java.io.IOException;

@ShellComponent
public class ShellCommand {

  @Autowired
  AuthorService authorService;

  @Autowired
  BookService bookService;

  @Autowired
  GenreService genreService;


  @ShellMethod(key = "create_author", value = "create username")
  public void createAuthor(
      @ShellOption({"username", "u"}) String username)  throws IOException {

    authorService.insertAuthor(username);

  }
  @ShellMethod(key = "reade_authors", value = "read authors")
  public void readAllAuthors(){
    authorService.readeAllAuthors().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_authors", value = "delete authors")
  public void deleteAuthorAccordingToId(@ShellOption({"id", "i"}) long id){
    authorService.deleteAuthorById(id);
  }


  @ShellMethod(key = "create_book", value = "create bookname")
  public void createBook(
      @ShellOption({"bookname", "b"}) Book book

  )  throws IOException {

    bookService.insertBook(book);

  }
  @ShellMethod(key = "reade_books", value = "read books")
  public void readAllBooks(){
    bookService.readeAllBooks().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_books", value = "delete books")
  public void deleteBookAccordingToId(@ShellOption({"id", "i"}) long id){
    bookService.deleteBookById(id);
  }


  @ShellMethod(key = "create_genre", value = "create genrename")
  public void createGenre(
      @ShellOption({"genrename", "b"}) String genrename)  throws IOException {

    genreService.insertGenre(genrename);

  }

  @ShellMethod(key = "reade_genres", value = "read genres")
  public void readAllGenres(){
    genreService.readeAllGenres().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_genre", value = "delete genres")
  public void deleteGenreAccordingToId(@ShellOption({"id", "i"}) long id){
    genreService.deleteGenreById(id);
  }


  @ShellMethod(key = "create_comment", value = "create comment")
  public void createComment(
      @ShellOption({"username", "u"}) String comment, @ShellOption({"bookId", "bId"}) Long id)  throws IOException {
    Book book = bookService.readeBookById(id);
    Comment comment1 = new Comment(comment, book);
    bookService.insertComment(comment1);
  }


}

