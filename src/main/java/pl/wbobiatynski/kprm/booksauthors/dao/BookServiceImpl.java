package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class BookServiceImpl implements BookService {
        BookRepository bookRepository;
        AuthorRepository authorRepository;
        AuthorServiceImpl authorService;

        @Autowired
        public BookServiceImpl(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        public void createBook(String title, String ISBN, ID authorId, String authorName, String authorSurname) {
            Book book = new Book();
            book.setTitle(title);
            book.setIsbn(ISBN);
            if (authorRepository.existsById(authorId)) {
                book.setAuthor(authorId);
            } else {
                book.setAuthor(authorService.createAuthor(authorName, authorSurname));
            }
            bookRepository.save(book);
        }

    @Override
    public void editBook(ID id, String title, Author author) {
    }
    @Override
    public void deleteBook(Book book) {
            bookRepository.delete(book);
    }

    public void editBook (ID id, String title, String ISBN) {
            Optional<Book> book = bookRepository.findById(id);
            book.get().setTitle(title);
            book.get().setIsbn(ISBN);
            bookRepository.save(book.get());
        }

    @Override
    public List<Book> listAllBooks() {
            return bookRepository.findAll();
    }
}

