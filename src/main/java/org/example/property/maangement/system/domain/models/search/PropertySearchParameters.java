package org.example.property.maangement.system.domain.models.search;

import org.example.property.maangement.system.domain.models.ListingType;
import org.example.property.maangement.system.domain.models.NumberOfBedRooms;

public class PropertySearchParameters {

    private final String location;
    private final PriceRange priceRange;
    private final ListingType listingType;
    private final Integer size;
    private final NumberOfBedRooms numberOfBedRooms;
    private final SortingOption sortingOption;

    public PropertySearchParameters(final String location, final PriceRange priceRange, final ListingType listingType,
            final Integer size, final NumberOfBedRooms numberOfBedRooms, final SortingOption sortingOption) {

        this.location = location;
        this.priceRange = priceRange;
        this.listingType = listingType;
        this.size = size;
        this.numberOfBedRooms = numberOfBedRooms;
        this.sortingOption = sortingOption;
    }

    public String getLocation() {

        return location;
    }

    public PriceRange getPriceRange() {

        return priceRange;
    }

    public ListingType getListingType() {

        return listingType;
    }

    public Integer getSize() {

        return size;
    }

    public NumberOfBedRooms getNumberOfBedRooms() {

        return numberOfBedRooms;
    }

    public SortingOption getSortingOption() {

        return sortingOption;
    }
}
