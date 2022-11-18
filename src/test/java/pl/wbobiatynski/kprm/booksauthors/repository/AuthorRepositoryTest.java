package pl.wbobiatynski.kprm.booksauthors.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class AuthorRepositoryTest {

    @Inject
    private AuthorRepository repository;

    @Test
    void should_get_all_3_Authors() {
        List<Author> list = repository.getAllAuthors();
        assertEquals(list.size(), 3);
    }

    @Test
    void should_get_Henryk_Sienkiewicz_ById_1() {
        Author firstAuthor = repository.getAuthorById(1L);
        assertEquals(firstAuthor.getName(), "Henryk");
        assertEquals(firstAuthor.getSurname(), "Sienkiewicz");
    }


    @Test
    void should_increment_books_number_after_saving_Author_Jerzy_Pilch_with() {
        Author jerzyPilch = new Author();
        jerzyPilch.setName("Jerzy");
        jerzyPilch.setName("Pilch");
        int authorsNumberBeforeSaving = repository.countAuthors();
        repository.saveAuthor(jerzyPilch);
        int authorsNumberAfterSaving = repository.countAuthors();
        assertEquals(authorsNumberAfterSaving, authorsNumberBeforeSaving + 1);
    }

    @Test
    void should_decrease_number_of_author_after_delete_HenrykSienkiewicz() {
        Author henrykSienkiewicz = new Author();
        henrykSienkiewicz.setName("Henryk");
        henrykSienkiewicz.setSurname("Sienkiewicz");
        int authorsNumberBeforeDeleting = repository.countAuthors();
        repository.deleteAuthor(henrykSienkiewicz);
        int authorsNumberAfterDeleting = repository.countAuthors();
        assertEquals(authorsNumberBeforeDeleting - 1, authorsNumberAfterDeleting);
    }

}