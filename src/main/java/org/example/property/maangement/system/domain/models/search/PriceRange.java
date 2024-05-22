package org.example.property.maangement.system.domain.models.search;

public class PriceRange {

    private final Integer minPrice;
    private final Integer maxPrice;

    public PriceRange(final Integer minPrice, final Integer maxPrice) {

        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {

        return minPrice;
    }

    public Integer getMaxPrice() {

        return maxPrice;
    }
}
