package org.example.property.maangement.system.domain.service;

import java.util.*;
import org.example.property.maangement.system.domain.models.Property;
import org.example.property.maangement.system.domain.models.search.PropertySearchParameters;
import org.example.property.maangement.system.domain.models.search.SortingOption;
import org.example.property.maangement.system.domain.service.searchstrategy.*;

public class PropertyService {

    private final List<Property> propertiesAvailableForRent;

    private final List<SearchStrategy> searchStrategies;

    public PropertyService() {

        this.propertiesAvailableForRent = new LinkedList<>();
        this.searchStrategies = Arrays.asList(new ListingTypeSearchStrategy(), new LocationSearchStrategy(),
                new NumberOfBedroomsSearchStrategy(), new PriceRangeSearchStrategy(), new PropertySizeSearchStrategy());
    }

    public void listProperty(final Property property) {

        if (propertiesAvailableForRent.contains(property)) {
            throw new RuntimeException("Property already listed for rent");
        }

        propertiesAvailableForRent.add(property);
        System.out.println("Property listed successfully.");
    }

    public List<Property> searchBy(final PropertySearchParameters propertySearchParameters) {

        List<Property> propertiesSearched = Collections.emptyList();

        for (SearchStrategy searchStrategy : searchStrategies) {
            propertiesSearched = searchStrategy.search(propertySearchParameters, propertiesSearched,
                    propertiesAvailableForRent);
        }

        return getSortedList(propertiesSearched, propertySearchParameters.getSortingOption());
    }

    private List<Property> getSortedList(final List<Property> properties, SortingOption sortingOption) {

        if (sortingOption.equals(SortingOption.PRICE)) {
            properties.sort(Comparator.comparing(Property::getPrice));
        } else {
            properties.sort(Comparator.comparing(Property::getSize));
        }

        return properties;
    }
}
