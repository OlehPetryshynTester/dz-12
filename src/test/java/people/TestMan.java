package people;


import dataproviders.TestDataProvider;
import org.people.Man;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)
    public void testGetFirstName(Man man){
    Assert.assertEquals(man.getFirstName(),man.getFirstName(), format("This man have incorrect firstname. " + "The firstname should be " + man.getFirstName()));
}
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)
    public void testGetLastName(Man man){
        Assert.assertEquals(man.getLastName(), man.getLastName(), format("This man have incorrect lastname. " + "The lastname should be " + man.getLastName()));
    }
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)

    public void  testGetAge(Man man){
        Assert.assertEquals(man.getAge(),man.getAge(), "This man have incorrect age");
}
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)

    public void testSetFirstName(Man man){
        man.setFirstName(man.getFirstName());
        Assert.assertEquals(man.getFirstName(),man.getFirstName(), format("This Woman have incorrect firstname. " + "The firstname should be " + man.getFirstName()));
    }
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)

    public void testSetLastName(Man man){
        man.setLastName(man.getLastName()) ;
        Assert.assertEquals(man.getLastName(), man.getLastName(), format("This Woman have incorrect lastname. " + "The lastname should be " + man.getLastName()));
    }
    @Test (dataProvider = "dataMan", dataProviderClass = TestDataProvider.class)

    public void  testSetAge(Man man) {
        man.setAge(man.getAge());
        Assert.assertEquals(man.getAge(), man.getAge(), "This Woman have incorrect age");

    }




}
