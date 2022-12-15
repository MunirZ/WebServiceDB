package munir.webservicedb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    public Article() {
    }
}
