package org.example.property.maangement.system.domain.service;

import java.util.List;
import org.example.property.maangement.system.domain.models.Property;
import org.example.property.maangement.system.domain.models.search.PropertySearchParameters;

public interface SearchStrategy {

    List<Property> search(final PropertySearchParameters propertySearchParameters,
            final List<Property> propertiesSearched, final List<Property> propertiesAvailableForRent);

}
