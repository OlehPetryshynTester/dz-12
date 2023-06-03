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


    @Test
    public void testPeopleHaveRetired() {
        Assert.assertTrue(man.isRetired(), format("Man %s with age %d should not be retired", man.getFirstName() +" "+ man.getLastName(), man.getAge()));
    }
    @Test
    public void testGetFirstName(){
    Assert.assertEquals(man.getFirstName(),"John", format("This man have incorrect firstname. " + "The firstname should be " + man.getFirstName()));
}
    @Test
    public void testGetLastName(){
        Assert.assertEquals(man.getLastName(), "Jonson", format("This man have incorrect lastname. " + "The lastname should be " + man.getLastName()));
    }
@Test
    public void  testGetAge(){
        Assert.assertEquals(man.getAge(),65, "This man have incorrect age");
}
    @Test
    public void testSetFirstName(){
        man.setFirstName("Tom");
        Assert.assertEquals(man.getFirstName(),"Tom", format("This Woman have incorrect firstname. " + "The firstname should be " + man.getFirstName()));
    }
    @Test
    public void testSetLastName(){
        man.setLastName("Tom") ;
        Assert.assertEquals(man.getLastName(), "Tom", format("This Woman have incorrect lastname. " + "The lastname should be " + man.getLastName()));
    }
    @Test
    public void  testSetAge() {
        man.setAge(60);
        Assert.assertEquals(man.getAge(), 60, "This Woman have incorrect age");

    }




}
