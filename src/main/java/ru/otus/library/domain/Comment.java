package ru.otus.library.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", nullable = false, unique = true)
  private String content;

  @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  private Book book;

  public Comment(String content, Book book) {
    this.content = content;
    this.book = book;
  }
  public Comment(Long id, String content, Book book) {
    this.id = id;
    this.content = content;
    this.book = book;
  }
  public Comment() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}
