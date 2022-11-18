package pl.wbobiatynski.kprm.booksauthors.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    @Pattern(regexp= "(^COI)", message = "Tytuł nie może zaczynać się od COI")
    private String title;
    @Basic
    @Column(name = "isbn")
    @Size(min = 13, max = 13, message = "ISBN musi mieć 13 znaków")
    private String isbn;
    @ManyToOne
    private Author author;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, author);
    }
}
