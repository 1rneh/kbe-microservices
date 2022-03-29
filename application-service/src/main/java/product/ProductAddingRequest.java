package product;

public record ProductAddingRequest(
        String name,
        String description,
        Double price,
        Boolean edible,
        String origin
) {}
