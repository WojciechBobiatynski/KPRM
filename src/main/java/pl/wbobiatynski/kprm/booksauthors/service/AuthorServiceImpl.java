package pl.wbobiatynski.kprm.booksauthors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import pl.wbobiatynski.kprm.booksauthors.repository.AuthorRepository;

import java.util.List;

    @Service
    public class AuthorServiceImpl implements AuthorService {
        @Autowired
        private AuthorRepository authorRepository;

        @Autowired
        public AuthorServiceImpl(AuthorRepository userRepository) {
            this.authorRepository = userRepository;
        }

        /**
         * To create author entity and return the id
         * */
        public void createAuthor(String name, String surname) {
            Author author = new Author();
            author.setName(name);
            author.setSurname(surname);

        }



        public void editAuthor(Long id, String name, String surname) {
            Author author = authorRepository.getAuthorById(id);
            author.setName(name);
            author.setSurname(surname);
        }

        @Override
        public List<Author> findAll() {
            return authorRepository.getAllAuthors();
        }

        public void deleteAuthor(Long authorId) {
            Author author = authorRepository.getAuthorById(authorId);
            if (author != null) {
                authorRepository.deleteAuthor(author);
            } else {
                throw new IllegalArgumentException("No author with given id");
            }
        }}

