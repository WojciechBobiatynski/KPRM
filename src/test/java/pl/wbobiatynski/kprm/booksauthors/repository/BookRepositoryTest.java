package pl.wbobiatynski.kprm.booksauthors.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import pl.wbobiatynski.kprm.booksauthors.entity.Book;

import javax.validation.ValidationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void should_get_All_5_Books() {
      List<?> bookList = repository.getAllBooks();
      assertEquals(bookList.size(), 5);
    }

    @Test
    void should_get_Ogniem_i_mieczem_BookById_1() {
        Book firstBook = repository.getBookById(1);
        assertEquals(firstBook.getTitle(), "Ogniem i mieczem");
        assertEquals(firstBook.getIsbn(), "1234567890ABC");

        Author authorOfFirstBook = firstBook.getAuthor();
        assertEquals(authorOfFirstBook.getName(), "Henryk");
        assertEquals(authorOfFirstBook.getName(), "Sienkiewicz");
    }

    @Test
    void should_get_Ziemia_Obiecana_book_after_save() {
        Author authorOfZiemiaObiecana = new Author();
        authorOfZiemiaObiecana.setName("Władysław");
        authorOfZiemiaObiecana.setSurname("Reymont");

        Book ziemiaObiecana = new Book();
        ziemiaObiecana.setAuthor(authorOfZiemiaObiecana);
        ziemiaObiecana.setIsbn("1234567890123");
        ziemiaObiecana.setTitle("Ziemia obiecana");

        Book savedZiemiaObiecana = repository.saveBook(ziemiaObiecana);

        Book selectedZiemiaObiecana = repository.getBookById(savedZiemiaObiecana.getId());
        assertEquals(selectedZiemiaObiecana.getTitle(), "Ziemia obiecana");
    }

    @Test
    void should_didnot_get_Ogniem_i_mieczem_book_after_delete_by_id_1() {
        repository.deleteBook(1L);
        Book ogniemIMieczemHandle = repository.getBookById(1);
        assertNull(ogniemIMieczemHandle);
    }

    @Test
    void should_raise_validation_error_saving_book_with_wrong_ISBN() {
          Book fakeBook = new Book();
          ValidationException optionallyThrowed = null;
          fakeBook.setTitle("fakeBook");
          fakeBook.setIsbn("isbnFakeThing");
          fakeBook.setTitle("Potęga podświadomości");
          Author author = new Author();
          author.setName("fakeAuthor");
          fakeBook.setAuthor(author);
     try {
          repository.saveBook(fakeBook);
     } catch (ValidationException e) {
         optionallyThrowed = e;
     } finally {
         assertNotNull(optionallyThrowed);
         }
     }



    @Test
    void should_raise_validation_error_saving_book_with_wrong_title() {
         Book fakeBook = new Book();
        ValidationException optionallyThrowed = null;
         fakeBook.setTitle("fakeBook");
         fakeBook.setIsbn("1234567890123");
         fakeBook.setTitle("COI Potęga podświadomości");
         Author author = new Author();
         author.setName("fakeAuthor");
         fakeBook.setAuthor(author);
        try {
            repository.saveBook(fakeBook);
        } catch (ValidationException e) {
            optionallyThrowed = e;
        } finally {
            assertNotNull(optionallyThrowed);
        }
    }

    @Test
    void should_count_books_on_number_5() {
        assertEquals(repository.countBooks(), 5);
    }
}