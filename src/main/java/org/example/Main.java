package org.example;

import java.util.List;
import org.example.property.maangement.system.domain.models.ListingType;
import org.example.property.maangement.system.domain.models.NumberOfBedRooms;
import org.example.property.maangement.system.domain.models.Property;
import org.example.property.maangement.system.domain.models.User;
import org.example.property.maangement.system.domain.models.search.PriceRange;
import org.example.property.maangement.system.domain.models.search.PropertySearchParameters;
import org.example.property.maangement.system.domain.models.search.SortingOption;
import org.example.property.maangement.system.domain.service.PropertyService;
import org.example.property.maangement.system.domain.service.UserService;

public class Main {

    public static void main(String[] args) {

        final UserService userService = new UserService();
        final PropertyService propertyService = new PropertyService();

        final User user1 = new User("Jack");
        userService.registerUser(user1);

        final Property property1 = new Property("Delhi", 100001, ListingType.RENT, 1300, NumberOfBedRooms.TWO_BHK);
        user1.listProperty(property1);
        propertyService.listProperty(property1);

        final Property property2 = new Property("Bangalore", 200001, ListingType.RENT, 1500, NumberOfBedRooms.THREE_BHK);
        user1.listProperty(property2);
        propertyService.listProperty(property2);

        final PriceRange priceRange1 = new PriceRange(100000, 200002);
        final PropertySearchParameters propertySearchParameters1 = new PropertySearchParameters("Bangalore",
                priceRange1, ListingType.RENT, 1500, NumberOfBedRooms.THREE_BHK, SortingOption.PRICE);
        final List<Property> propertiesListedByUser1 = userService.viewListingsByGivenUser(user1);
        final List<Property> propertiesSearched1 = propertyService.searchBy(propertySearchParameters1);
        System.out.println("==================");
        System.out.println("Printing result as per 1st search criteria");
        printResult(propertiesSearched1);

        final PriceRange priceRange2 = new PriceRange(100000, 200002);
        final PropertySearchParameters propertySearchParameters2 = new PropertySearchParameters("Delhi",
                priceRange2, ListingType.RENT, 1300, NumberOfBedRooms.TWO_BHK, SortingOption.PRICE);
        final List<Property> propertiesSearched2 = propertyService.searchBy(propertySearchParameters2);
        System.out.println("==================");
        System.out.println("Printing result as per 2nd search criteria");
        printResult(propertiesSearched2);
    }

    private static void printResult(List<Property> properties) {

        if (properties.isEmpty()) {
            System.out.println("Empty");
        }

        for (Property property : properties) {
            System.out.println(property);
        }
    }
}
