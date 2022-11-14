package pl.wbobiatynski.kprm.booksauthors.service;

import pl.wbobiatynski.kprm.booksauthors.entity.Book;

import java.util.List;

public interface BookService {
     void createBook(String ISBN, String title, long authorId, String authorName, String authorSurname);
     void editBook(Integer id, String title, String ISBN);
     void deleteBook(Integer id);
     List<Book> listAllBooks();
}
