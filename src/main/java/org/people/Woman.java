package org.people;

public class Woman extends Person {

    public Woman(String firstName, String lastname, int age) {
        super(firstName, lastname, age);
    }

    @Override
    public boolean isRetired() {
        return getAge() >= 60;
    }

    @Override
    public void registerPartnership(Person partner) {
        this.partner = partner;
        Woman woman = this;
        previousLastName = woman.lastName;
        woman.lastName = partner.lastName;
    }

        @Override
    public void deregisterPartnership(boolean revertLastName) {
            if (partner != null && revertLastName) {
             Woman woman = this;
             String tempLastName = woman.lastName;
             woman.lastName = previousLastName;
             previousLastName = tempLastName;
         }
         this.partner = null;
     }

    }


