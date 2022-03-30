package com.henri.kbe;

import com.henri.kbe.domain.model.Product;
import com.henri.kbe.adapter.data.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ProductConfig {

    @LoadBalanced
    @Bean
    @Primary
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("qualifiedBean")
    public RestTemplate externalRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product apple = new Product(
                    "apple",
                    "is tasty and red",
                    1.99,
                    true,
                    "Italy"
            );

            Product pear = new Product(
                    "pear",
                    "is not tasty and yellow",
                    1.99,
                    true,
                    "Caucasus"
            );
            Product hummus = new Product(
                    "hummus",
                    "selfmade",
                    0.00,
                    true,
                    "home"
            );

            Product lamp = new Product(
                    "lamp",
                    "comes with led bulb",
                    19.99,
                    false,
                    "Germany"
            );
            Product tomatoes = new Product(
                    "tomatoes",
                    "organically grown",
                    2.99,
                    true,
                    "Ecuador"
            );

            Product book = new Product(
                    "book",
                    "psycho thriller",
                    12.99,
                    false,
                    "Great Britain"
            );
            Product monitor = new Product(
                    "monitor",
                    "13 inches",
                    199.99,
                    false,
                    "China"
            );

            Product coffee = new Product(
                    "coffee",
                    "blend",
                    7.99,
                    true,
                    "Ethiopia"
            );

            Product carrot = new Product(
                    "carrot",
                    "of the color orange",
                    0.59,
                    true,
                    "Germany"
            );

            Product cream = new Product(
                    "cream",
                    "lavendel and lemon grass",
                    4.99,
                    false,
                    "supermarket"
            );

            productRepository.deleteAll();
            productRepository.saveAll(
                    List.of(apple, pear, hummus, lamp, tomatoes, book, monitor, coffee, carrot, cream)
            );

        };
    }
}
