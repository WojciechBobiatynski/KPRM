
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CRUDBooksRepository extends JPARepository<Book, Long> {
    void addBook(Book book);
    Book editBook(Book book);
    List<Book> displayAllBooks();
}
