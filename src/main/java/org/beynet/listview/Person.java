package org.beynet.listview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by beynet on 29/04/2015.
 */
public class Person {
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty();
        this.firstName.set(firstName);
        this.lastName = new SimpleStringProperty();
        this.lastName.set(lastName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName();
    }


    /**
     * permut first and last name
     */
    public void permutFirstNameAndLastName() {
        String first = this.firstName.get();
        this.firstName.set(getLastName());
        this.lastName.set(first);
    }

    private StringProperty firstName;
    private StringProperty lastName;
}
