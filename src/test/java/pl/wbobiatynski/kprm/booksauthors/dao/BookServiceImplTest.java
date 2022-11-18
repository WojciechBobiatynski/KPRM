package pl.wbobiatynski.kprm.booksauthors.dao;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import pl.wbobiatynski.kprm.booksauthors.entity.Book;
import pl.wbobiatynski.kprm.booksauthors.repository.AuthorRepository;
import pl.wbobiatynski.kprm.booksauthors.repository.BookRepository;
import pl.wbobiatynski.kprm.booksauthors.service.BookServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Configuration
@EnableJpaRepositories(basePackageClasses = {BookRepository.class, AuthorRepository.class})

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = { })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class BookServiceImplTest {

    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void createBook() {
        bookService.createBook("Wladca pierscieni", "1234567890123", 1L, "Wladislaw", "Tolkien");
        List<Book> bookList = bookService.listAllBooks();
        assertEquals(bookList.size(), 6);
    }

    @Test
    void editBook() {
        bookService.editBook(5, "Pan Tadeusz", "1234567890123");
    }

    @Test
    void should_decrease_number_of_book_after_deleteBook() {
        bookService.deleteBook(1L);
        List<Book> bookList = bookService.listAllBooks();
        assertEquals(bookList.size(), 4);
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_list_5_Books_and_first_as_ogniem_i_mieczem() {
        BookServiceImpl bookService = new BookServiceImpl(bookRepository, authorRepository);
        List<Book> bookList =  bookService.listAllBooks();
        assertEquals(bookList.size(), 5);
        int i = 0;
        for (Book bookFromDb : bookList) {
             String title = (String) bookFromDb.getTitle();
             if (i == 0) {
                 assertEquals(title, "Ogniem i mieczem");
             }
             String isbn = (String) bookFromDb.getIsbn();
             Author authorId = bookFromDb.getAuthor();
             i++;
        }
    }
}