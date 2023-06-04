package models;

import com.opencsv.bean.CsvBindByName;

public class PersonDataWoman {
    @CsvBindByName(column = "First name")
    private String firstName;

    @CsvBindByName(column = "Last name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @CsvBindByName(column = "age")
    private int age;
}
