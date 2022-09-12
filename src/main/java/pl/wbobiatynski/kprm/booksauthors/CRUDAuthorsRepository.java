package pl.wbobiatynski.kprm.booksauthors;

import org.springframework.data.repository.CrudRepository;

public interface CRUDAuthorsRepository extends JPARepository<Author, Long> {
        void addAuthor(Author author);
        Author editAuthor(Author book);
        List<Author> displayAllAuthors();
    }
}
