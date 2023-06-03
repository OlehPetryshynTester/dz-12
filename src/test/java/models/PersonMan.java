package models;

import com.opencsv.bean.CsvBindByName;

public class PersonMan {
    public String getFirstName() {
        return firstName;
    }

    @CsvBindByName(column = "firstName")
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    @CsvBindByName(column = "lastName")
    private String lastName;
}
