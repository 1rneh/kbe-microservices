package product;

import java.util.Date;

public record ProductAddingRequest(
        String name,
        String description,
        double price,
        boolean edible,
        String origin,
        Date deliveryDate
) {}
