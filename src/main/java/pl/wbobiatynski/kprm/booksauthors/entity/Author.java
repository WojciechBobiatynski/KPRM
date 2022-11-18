package pl.wbobiatynski.kprm.booksauthors.entity;
import javax.persistence.*;

@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String title) {
        this.surname = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}



