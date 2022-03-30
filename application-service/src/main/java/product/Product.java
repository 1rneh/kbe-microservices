package product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    @Column(updatable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean edible;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private Date deliveryDate;

    public Product(String name, String description, double price, boolean edible, String origin) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.edible = edible;
        this.origin = origin;
        this.deliveryDate = Date.from(Instant.now().plus(Duration.ofDays(5)));;
    }

}
