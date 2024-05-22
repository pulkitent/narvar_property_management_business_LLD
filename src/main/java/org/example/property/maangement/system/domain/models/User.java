package org.example.property.maangement.system.domain.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {

    private final String name;
    private final List<Property> propertiesListed;
    private final List<Property> propertiesRented;

    public User(String name) {

        this.name = name;
        this.propertiesListed = new LinkedList<>();
        this.propertiesRented = new LinkedList<>();
    }

    public List<Property> getPropertiesListed() {

        return propertiesListed;
    }

    public void listProperty(final Property property) {

        propertiesListed.add(property);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(name);
    }
}
