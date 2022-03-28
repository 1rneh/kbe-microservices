package storage;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
public class DeliveryInfo {

    @Id
    private long id;

    private String name;

    private Date deliveryTime;

    private BigDecimal amount;

    private String location;

    public DeliveryInfo(String name, Date deliveryTime, BigDecimal amount, String location) {
        this.name = name;
        this.deliveryTime = deliveryTime;
        this.amount = amount;
        this.location = location;
    }
}
