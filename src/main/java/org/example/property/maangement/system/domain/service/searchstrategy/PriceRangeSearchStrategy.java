package org.example.property.maangement.system.domain.service.searchstrategy;

import java.util.LinkedList;
import java.util.List;
import org.example.property.maangement.system.domain.models.Property;
import org.example.property.maangement.system.domain.models.search.PriceRange;
import org.example.property.maangement.system.domain.models.search.PropertySearchParameters;
import org.example.property.maangement.system.domain.service.SearchStrategy;

public class PriceRangeSearchStrategy implements SearchStrategy {

    @Override
    public List<Property> search(final PropertySearchParameters propertySearchParameters,
            final List<Property> propertiesSearched, final List<Property> propertiesAvailableForRent) {

        final List<Property> propertySearched = new LinkedList<>();

        for (Property property : propertiesSearched) {
            final PriceRange priceRange = propertySearchParameters.getPriceRange();

            if (property.getPrice() >= priceRange.getMinPrice()
                    && property.getPrice() <= priceRange.getMaxPrice()) {
                propertySearched.add(property);
            }
        }
        return propertySearched;
    }
}
