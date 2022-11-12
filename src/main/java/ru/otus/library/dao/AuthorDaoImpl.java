package ru.otus.library.dao;

import org.springframework.stereotype.Repository;
import ru.otus.library.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorDaoImpl implements AuthorDao {

  @PersistenceContext
  private final EntityManager em;

  public AuthorDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void insertAuthor(String name) {
    Author author = new Author(name);
    if (author.getId() <= 0) {
      em.persist(author);
    } else {
      em.merge(author);
    }
  }

  @Override
  public Optional<Author> readeAuthorById(Long id) {
    return Optional.ofNullable(em.find(Author.class, id));
  }

  @Override
  public List<Author> readeAllAuthors() {
    TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
    return query.getResultList();
  }

  @Override
  public void deleteAuthorById(Long id) {
    Query query = em.createQuery("delete " +
        "from Author a " +
        "where a.id = :id");
    query.setParameter("id", id);
    query.executeUpdate();
  }
}



