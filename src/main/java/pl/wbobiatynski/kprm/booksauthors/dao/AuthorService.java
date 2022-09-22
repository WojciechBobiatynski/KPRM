package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
    public interface AuthorService {
        public ID createAuthor(String name, Author author);
        public ID editAuthor(Long id, String name, String surname);
        public void deleteAuthor(Author author);
}
