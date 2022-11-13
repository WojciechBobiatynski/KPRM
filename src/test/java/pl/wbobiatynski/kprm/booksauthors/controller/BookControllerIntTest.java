package pl.wbobiatynski.kprm.booksauthors.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.wbobiatynski.kprm.booksauthors.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)

public class BookControllerIntTest {
   @Autowired
   private MockMvc mvc;
   @MockBean
   private BookRepository bookRepository;

   @Test
   void getAllBooksTest () throws Exception {
       RequestBuilder request = MockMvcRequestBuilders.post("/books/getAllBooks");
       mvc.perform(request).andReturn();
       long booksSize = bookRepository.countBooks();
       assertEquals(booksSize, 5);
   }
}
