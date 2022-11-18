package pl.wbobiatynski.kprm.booksauthors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wbobiatynski.kprm.booksauthors.entity.Book;
import pl.wbobiatynski.kprm.booksauthors.exception.BookValidationException;
import pl.wbobiatynski.kprm.booksauthors.service.BookService;
import pl.wbobiatynski.kprm.booksauthors.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService ;
    public BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books/getAllBooks")
    @GetMapping
    public List<Book> findAll() {
        return bookService.listAllBooks();
    }

    @DeleteMapping ("/deleteBook/{id}")

    public ResponseEntity<Book> deleteBook (@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createBook/{title}/{isbn}/{authorName}/{authorSurname}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook (@PathVariable String title, @PathVariable String isbn, @PathVariable String authorName,
                                            @PathVariable String authorSurname) {
        bookService.createBook(title, isbn, 1, authorName, authorSurname);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editBook/{id}/{title}/{ISBN}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editBook (@PathVariable Integer id, @PathVariable String title, @PathVariable String ISBN) {
        bookService.editBook(id, title, ISBN);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<BookValidationException> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new BookValidationException(exception.getMessage()));
    }
}
