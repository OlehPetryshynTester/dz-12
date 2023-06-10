package people;


import dataproviders.TestDataProvider;
import org.people.Man;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public  class TestMan  {


    private Man man;

    @BeforeTest
   @Parameters({
        "firstNameMan",
        "lastNameMan",
        "ageMan"
})
    public void creatingMan(String firstNameMan , String lasNameMan , int ageMan) {
         man = new Man(firstNameMan, lasNameMan, ageMan);
    }


    @Test(dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)
    public void testRetiredMan(Man man) {
        Assert.assertTrue(man.isRetired(),  format("This man is not retired. His age is " + man.getAge()));
    }
    @Test (dataProvider = "manDataProviderFirstName", dataProviderClass = TestDataProvider.class)
    public void testGetFirstName(Man man, String expectedFirstName){
    Assert.assertEquals(man.getFirstName(),expectedFirstName, format("This man have incorrect firstname. " + "The firstname should be " + expectedFirstName));
}
    @Test (dataProvider = "manDataProviderLastName", dataProviderClass = TestDataProvider.class)
    public void testGetLastName(Man man, String expectedLastName){
        Assert.assertEquals(man.getLastName(), expectedLastName, format("This man have incorrect lastname. " + "The lastname should be " + expectedLastName));
    }
    @Test (dataProvider = "manDataProviderAge", dataProviderClass = TestDataProvider.class)

    public void  testGetAge(Man man, int expectedAge){
        Assert.assertEquals(man.getAge(),expectedAge, format("This man have incorrect age" + "The lastname should be " + expectedAge));
}
    @Test

    public void testSetFirstName(){
        String[] firstNames = {"John", "Jane", "David", "Emily", "Michael"};
        Random random = new Random();
        String randomFirstNames = firstNames[random.nextInt(firstNames.length)];
        man.setFirstName(randomFirstNames);
        Assert.assertEquals(man.getFirstName(),randomFirstNames, format("This Man have incorrect firstname. " + "The firstname should be " + man.getFirstName()));
    }

@Test
    public void testSetLastName(){
        String[] lastNames = {"Cook","Mickle","Green","Jones","mazafaka"};
                Random random = new Random();
                String randomLastNames = lastNames[random.nextInt(lastNames.length)];
        man.setLastName(randomLastNames) ;
        Assert.assertEquals(man.getLastName(), randomLastNames, format("This Man have incorrect lastname. " + "The lastname should be " + man.getLastName()));
    }
@Test
    public void  testSetAge() {
        int newAge = new Random().nextInt(100);
        man.setAge(newAge);
        Assert.assertEquals(man.getAge(), newAge, "This Man have incorrect age");

    }




}
