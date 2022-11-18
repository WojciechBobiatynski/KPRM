package pl.wbobiatynski.kprm.booksauthors.repository;

import org.springframework.stereotype.Repository;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> getAllAuthors() {
        Query query = entityManager.createQuery("SELECT name, surname from Author");
        return (List<Author>) query.getResultList();
    }

    public Author getAuthorById (Long authorId) {
        Query query = entityManager.createQuery("SELECT * from AUTHOR WHERE id = " + authorId);
        return (Author) query.getSingleResult();
    }

    public Author saveAuthor(Author entity) {
        Query query = entityManager.createQuery("INSERT INTO AUTHOR (name, surname) VALUES ( " + entity.getName() + " ," + entity.getSurname() );
        return (Author) query.getSingleResult();
    }

    public void deleteAuthor(Author author) {
        entityManager.createQuery("delete * from AUTHOR WHERE id = " + author.getId());

    }

    public int countAuthors() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM Author");
        return (int) query.getSingleResult();
    }
}
