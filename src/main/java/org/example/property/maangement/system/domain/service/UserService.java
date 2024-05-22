package org.example.property.maangement.system.domain.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.example.property.maangement.system.domain.models.Property;
import org.example.property.maangement.system.domain.models.User;

public class UserService {

    private final List<User> registeredUsers;

    public UserService() {

        this.registeredUsers = new LinkedList<>();
    }

    public void registerUser(final User user) {

        if (registeredUsers.contains(user)) {
            throw new RuntimeException("User already registered");
        }

        registeredUsers.add(user);
        System.out.println("User registered successfully.");
    }

    public List<Property> viewListingsByGivenUser(final User user) {

        for (User u : registeredUsers) {
            if (u.equals(user)) {
                return u.getPropertiesListed();
            }
        }

        return Collections.emptyList();
    }
}
