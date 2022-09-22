package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceImplTest {

    BookRepository bookRepository;

    @Test
    void createBook() {
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.createBook("Wladca pierscieni", "1234567890123", 1L);
        List<Book> bookList = bookService.listAllBooks();
        assertEquals(bookList.size(), 6);
    }

    @Test
    void editBook() {
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.editBook(5L, "Pan Tadeusz", "1234567890123");
    }


    @Test
    void deleteBook() {
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.deleteBook(new Book("Ogniem i mieczem", 1));
        List<Book> bookList = bookService.listAllBooks();
        assertEquals(bookList.size(), 4);
    }

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void listAllBooksTest() {
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        List<Book> bookList =  bookService.listAllBooks();
        assertEquals(bookList.size(), 5);
        for (Book bookFromDb : bookList) {
             String title = bookFromDb.getTitle();
             String isbn = bookFromDb.getIsbn();
             ID authorId = bookFromDb.getAuthor();
        }
    }
}