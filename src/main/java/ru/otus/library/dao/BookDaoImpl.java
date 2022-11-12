package ru.otus.library.dao;

import org.springframework.stereotype.Repository;
import ru.otus.library.domain.Book;
import ru.otus.library.domain.Comment;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

  @PersistenceContext
  private final EntityManager em;

  public BookDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void insertBook(Book book) {
    if (book.getId() <= 0) {
      em.persist(book);

    } else {
      em.merge(book);
    }
  }

  @Override
  public Book readeBookById(Long id) {
    return em.find(Book.class, id);
  }

  @Override
  public List<Book> readeAllBooks() {
    EntityGraph<?> entityGraph = em.getEntityGraph("book-author-genre-commentList-entity-graph");
    TypedQuery<Book> query = em.createQuery("select s from Book s", Book.class);
    query.setHint("javax.persistence.fetchgraph", entityGraph);
    return query.getResultList();
  }

  @Override
  public void deleteBookById(Long id) {
    Book book = em.find(Book.class, id);
    em.remove(book);
  }

  @Override
  public void insertComment(Comment comment) {
    if (comment.getId() <= 0) {
      em.persist(comment);
    }
    else {
    em.merge(comment);
  }
  }

}
