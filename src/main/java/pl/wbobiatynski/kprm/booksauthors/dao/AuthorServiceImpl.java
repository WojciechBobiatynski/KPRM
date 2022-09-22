package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

    @Service
    public class AuthorServiceImpl  {
        AuthorRepository authorRepository;

        @Autowired
        public AuthorServiceImpl(AuthorRepository userRepository) {
            this.authorRepository = userRepository;
        }

        /**
         * To create author entity and return the id
         * */
        public ID createAuthor(String name, String surname) {
            Author author = new Author();
            author.setName(name);
            author.setSurname(surname);
            return authorRepository.save(author).getId();
        }

        public Long editAuthor(ID id, String name, String surname) {
            Optional<Author> author = authorRepository.findById(id);
            author.get().setName(name);
            author.get().setSurname(surname);
            return authorRepository.save(author.get()).getId();
        }

        public void deleteAuthor(Author author) {
            authorRepository.delete(author);
        }
    }

