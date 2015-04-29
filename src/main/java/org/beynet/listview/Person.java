package org.beynet.listview;

/**
 * Created by beynet on 29/04/2015.
 */
public class Person {
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName();
    }

    private String firstName;
    private String lastName;
}
