package org.example.property.maangement.system.domain.models;

import java.util.Objects;

public class Property {

    private final String location;
    private final Integer price;
    private final ListingType listingType;
    private final Integer size;
    private final NumberOfBedRooms numberOfBedRooms;

    public Property(final String location, final Integer price, final ListingType listingType,
            final Integer size, final NumberOfBedRooms numberOfBedRooms) {

        this.location = location;
        this.price = price;
        this.listingType = listingType;
        this.size = size;
        this.numberOfBedRooms = numberOfBedRooms;
    }

    public String getLocation() {

        return location;
    }

    public Integer getPrice() {

        return price;
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

    @Override
    public String toString() {

        return "Property{" +
                "location='" + location + '\'' +
                ", price=" + price +
                ", listingType=" + listingType +
                ", size=" + size +
                ", numberOfBedRooms=" + numberOfBedRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Property property = (Property) o;
        return Objects.equals(location, property.location) && Objects.equals(price, property.price)
                && listingType == property.listingType && Objects.equals(size, property.size)
                && numberOfBedRooms == property.numberOfBedRooms;
    }

    @Override
    public int hashCode() {

        return Objects.hash(location, price, listingType, size, numberOfBedRooms);
    }
}
