import sun.jvm.hotspot.debugger.Page;

import javax.persistence.*;
import java.util.Set;

import java.util.List;

@Entity
@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Page> pages;
    private Set<Author> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }



    public void setUsers(Set<Author> users) {
        this.users = users;
    }




    public void setPages(Integer nom) {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

}

