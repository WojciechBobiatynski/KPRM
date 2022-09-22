package pl.wbobiatynski.kprm.booksauthors.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "BOOK")
public class Book extends AbstractPersistable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private ID id;

    @Column(name = "TITLE")
    @Pattern(regexp = "^(COI).*$", message = "Tytuł nie może zaczynać się od COI")
    private String title;

    @Column(name = "ISBN")
    @Size(min = 13, max = 13, message = "Rozmiar ISBN powinien być 13")
    private String isbn;

    @Column(name = "AUTHOR")
    private ID author;
}
