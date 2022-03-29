package storage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Configuration
public class DeliveryInfoConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeliveryInfoRepository deliveryInfoRepository) {
        return args -> {
            DeliveryInfo apple = new DeliveryInfo(
                    "apple",
                    new Date(),
                    BigDecimal.TEN,
                    "here"
            );

            DeliveryInfo pear = new DeliveryInfo(
                    "pear",
                    new Date(),
                    BigDecimal.ONE,
                    "here"
            );
            DeliveryInfo hummus = new DeliveryInfo(
                    "hummus",
                    new Date(),
                    BigDecimal.TEN,
                    "here"
            );

            DeliveryInfo lamp = new DeliveryInfo(
                    "lamp",
                    new Date(),
                    BigDecimal.ZERO,
                    "here"
            );
            DeliveryInfo tomatoes = new DeliveryInfo(
                    "tomatoes",
                    new Date(),
                    BigDecimal.TEN,
                    "here"
            );

            DeliveryInfo book = new DeliveryInfo(
                    "book",
                    new Date(),
                    BigDecimal.TEN,
                    "here"
            );
            DeliveryInfo monitor = new DeliveryInfo(
                    "monitor",
                    new Date(),
                    BigDecimal.ZERO,
                    "here"
            );

            DeliveryInfo coffee = new DeliveryInfo(
                    "coffee",
                    new Date(),
                    BigDecimal.ONE,
                    "here"
            );
            DeliveryInfo carrot = new DeliveryInfo(
                    "carrot",
                    new Date(),
                    BigDecimal.ZERO,
                    "here"
            );

            DeliveryInfo cream = new DeliveryInfo(
                    "cream",
                    new Date(),
                    BigDecimal.TEN,
                    "here"
            );

            deliveryInfoRepository.saveAll(
                    List.of(apple, pear, hummus, lamp, tomatoes, book, monitor, coffee, carrot, cream)
            );
        };
    }

}
