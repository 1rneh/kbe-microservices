package deliveryinfoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryInfo {

    @Id
    @SequenceGenerator(
            name = "delivery_info_id_sequence",
            sequenceName = "delivery_info_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "delivery_info_id_sequence"
    )
    private Integer id;

    private String name;

    private Date deliveryTime;

    private String location;

}
