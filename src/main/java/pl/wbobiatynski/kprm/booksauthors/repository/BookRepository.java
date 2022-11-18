package pl.wbobiatynski.kprm.booksauthors.repository;

import org.springframework.stereotype.Repository;
import pl.wbobiatynski.kprm.booksauthors.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public  class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<?> getAllBooks() {
        Query query = entityManager.createQuery("SELECT title, isbn, author from Book");
        return  query.getResultList();
    }

    public Book getBookById (int bookId) {
        Query query = entityManager.createQuery("SELECT * from Book WHERE id = " + bookId);
        return (Book) query.getSingleResult();
    }

    public Book saveBook(Book entity) {
        Query query = entityManager.createQuery("INSERT INTO Book (author, ISBN, title) VALUES ( " + entity.getAuthor().getId() + " ," + entity.getIsbn() + " ," + entity.getTitle() );
        return (Book) query.getSingleResult();
    }

    public void deleteBook (Long id) {
     entityManager.createQuery("delete * from Book WHERE id = " + id);
    }

    public int countBooks() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM Book");
        return (int) query.getSingleResult();
    }
}

