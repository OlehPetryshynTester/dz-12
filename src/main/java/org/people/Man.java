package org.people;

public class Man extends Person {


    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return getAge() >= 65;}

    @Override
    public void registerPartnership(Person partner) {

    }

    @Override
    public void deregisterPartnership(boolean revertLastName) {

    }



}










