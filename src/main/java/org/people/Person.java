package org.people;

public abstract class Person  {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;
    protected String lastName;
    private int age;

    public Person getPartner() {
        return partner;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    protected Person partner;

    protected String previousLastName;

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = getPartner();


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract boolean isRetired();
//        // Перевірка на пенсійний вік
//        if (this instanceof Woman) {
//            return age >= 60;
//        } else if (this instanceof Man) {
//            return age >= 65;
//        } else {
//            return false;
//        }

     public abstract void registerPartnership(Person partner);

//         this.partner = partner;
//         if (this instanceof Woman) {
//             Woman woman = (Woman) this;
//             previousLastName = woman.lastName;
//             woman.lastName = partner.lastName;
//         }
//    }
     public abstract void deregisterPartnership(boolean revertLastName);
//     {
//         if (this instanceof Woman && partner != null && revertLastName) {
//             Woman woman = (Woman) this;
//             String tempLastName = woman.lastName;
//             woman.lastName = previousLastName;
//             previousLastName = tempLastName;
//         }
//         this.partner = null;
//     }


    public String getPreviousLastName() {
        return previousLastName;
    }


    public String toString() {
        String partnerInfo = (partner != null) ? ", Partner: " + partner.firstName + " " + partner.lastName : "";
        return "Name: " + firstName + " " + lastName + ", Age: " + age + partnerInfo;
    }





}

