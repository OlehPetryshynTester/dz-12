package models;

import com.opencsv.bean.CsvBindByName;

public class PersonWoman {
    public String getLastname() {
        return lastName;
    }

    @CsvBindByName(column = "lastName")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    @CsvBindByName(column = "lastName")
    private String firstName;
}

