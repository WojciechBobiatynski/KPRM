package pl.wbobiatynski.kprm.booksauthors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import pl.wbobiatynski.kprm.booksauthors.entity.Book;
import pl.wbobiatynski.kprm.booksauthors.repository.AuthorRepository;
import pl.wbobiatynski.kprm.booksauthors.repository.BookRepository;

import javax.inject.Inject;
import java.util.List;

@Service
public  class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public void createBook(String title, String ISBN, long authorId,
                           String authorName, String authorSurname) {
            Book book = new Book();
            book.setTitle(title);
            book.setIsbn(ISBN);
            if (authorRepository.getAuthorById(authorId) != null) {
                Author author = authorRepository.getAuthorById(authorId);
                book.setAuthor(author);
            } else {
                Author author = new Author();
                author.setName(authorName);
                author.setSurname(authorSurname);
                author = authorRepository.saveAuthor(author);
                book.setAuthor(author);
            }
            bookRepository.getBookById(book.getId());
        }
    public void editBook (Integer id, String title, String ISBN) {
            Book book = bookRepository.getBookById(id);
            if (book != null) {
                book.setTitle(title);
                book.setIsbn(ISBN);
                bookRepository.saveBook(book);
            } else {
                throw new IllegalArgumentException("There is no book with given id identifier");
            }
        }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> listAllBooks() {
        return (List<Book>) bookRepository.getAllBooks();
    }
}

