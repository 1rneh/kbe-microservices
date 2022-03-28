package storage;

import java.math.BigDecimal;

public record DeliveryAddingRequest(
        String name,
        BigDecimal amount,
        String location
) {
}
