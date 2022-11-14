package pl.wbobiatynski.kprm.booksauthors.service;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import java.util.List;

    public interface AuthorService {
        void createAuthor(String name, String surname);
        void editAuthor(Long id, String name, String surname);
         void deleteAuthor(Long id);

         List<Author> findAll();
}
