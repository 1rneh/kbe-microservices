package com.henri.kbe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.henri.kbe.domain.model.DeliveryInfo;
import com.henri.kbe.adapter.data.DeliveryInfoRepository;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Instant;
import java.util.List;

@Configuration
public class StorageConfig {

    @LoadBalanced
    @Bean
    CommandLineRunner commandLineRunner(DeliveryInfoRepository deliveryInfoRepository) {
        return args -> {
            DeliveryInfo apple = new DeliveryInfo(
                    "apple",
                    Instant.now().toEpochMilli(),
                    BigDecimal.TEN,
                    "here"
            );

            DeliveryInfo pear = new DeliveryInfo(
                    "pear",
                    Instant.now().toEpochMilli(),
                    BigDecimal.ONE,
                    "lost"
            );
            DeliveryInfo hummus = new DeliveryInfo(
                    "hummus",
                    Instant.now().toEpochMilli(),
                    BigDecimal.TEN,
                    "somewhere else"
            );

            DeliveryInfo lamp = new DeliveryInfo(
                    "lamp",
                    Instant.now().toEpochMilli(),
                    BigDecimal.ZERO,
                    "somewhere"
            );
            DeliveryInfo tomatoes = new DeliveryInfo(
                    "tomatoes",
                    Instant.now().toEpochMilli(),
                    BigDecimal.TEN,
                    "there"
            );

            DeliveryInfo book = new DeliveryInfo(
                    "book",
                    Instant.now().toEpochMilli(),
                    BigDecimal.TEN,
                    "here"
            );
            DeliveryInfo monitor = new DeliveryInfo(
                    "monitor",
                    Instant.now().toEpochMilli(),
                    BigDecimal.ZERO,
                    "behind you"
            );

            DeliveryInfo coffee = new DeliveryInfo(
                    "coffee",
                    Instant.now().toEpochMilli(),
                    BigDecimal.ONE,
                    "around the corner"
            );
            DeliveryInfo carrot = new DeliveryInfo(
                    "carrot",
                    Instant.now().toEpochMilli(),
                    BigDecimal.ZERO,
                    "nowhere"
            );

            DeliveryInfo cream = new DeliveryInfo(
                    "cream",
                    Instant.now().toEpochMilli(),
                    BigDecimal.TEN,
                    "where"
            );

            deliveryInfoRepository.deleteAll();
            deliveryInfoRepository.saveAll(
                    List.of(apple, pear, hummus, lamp, tomatoes, book, monitor, coffee, carrot, cream)
            );
        };
    }

}
