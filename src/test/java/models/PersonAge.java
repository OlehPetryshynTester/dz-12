package models;

import com.opencsv.bean.CsvBindByName;

public class PersonAge {

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

   @CsvBindByName(column = "num1")
    private int num1;

    public int getNum2() {
        return num2;
    }

    @CsvBindByName(column = "num2")
    private int num2;

}
