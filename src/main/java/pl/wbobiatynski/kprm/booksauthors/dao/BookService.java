package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public void createBook(String ISBN, String title, ID authorId, String authorName, String authorSurname);
    public void editBook(ID id, String title, Author author);
    public void deleteBook(Book book);
    public List<Book> listAllBooks();
}
