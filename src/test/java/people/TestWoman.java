package people;

import dataproviders.TestDataProvider;
import models.PersonDataWoman;
import org.people.Man;
import org.people.Person;
import org.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;


public class TestWoman {

    private static class TestPerson extends Person {
        public TestPerson(String firstName, String lastName, int age) {
            super(firstName, lastName, age);
        }

        @Override
        public boolean isRetired() {
            return false;
        }

        @Override
        public void registerPartnership(Person partner) {

        }

        @Override
        public void deregisterPartnership(boolean revertLastName) {

        }

    }


private  Woman woman;

    @BeforeTest
    @Parameters({
            "firstNameWoman",
            "lastNameWoman",
            "ageWoman",

    })
    public void creatingWoman(String firstNameWoman, String lastNameWoman, int ageWoman) {
         woman = new Woman(firstNameWoman, lastNameWoman, ageWoman);
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)

    public void testPeopleHaveRetired(Woman woman) {

    Assert.assertTrue(woman.isRetired(), format("Woman %s with age %d should not be retired", woman.getLastName() + " " + woman.getLastName(), woman.getAge()));

    }


    @Test
    @Parameters({
            "firstNameMan",
            "lastNameMan",
            "ageMan"
    })
    public void testRegisterPartnership(String firstNameMan , String lasNameMan , int ageMan) {
        woman.setLastName(woman.getLastName());
        woman.setFirstName(woman.getFirstName());

        TestPerson partner = new TestPerson(firstNameMan, lasNameMan, ageMan);
        partner.setLastName("Smith");
        partner.setFirstName("John");

        woman.registerPartnership(partner);

        Assert.assertEquals(partner, woman.getPartner());
        Assert.assertEquals(partner.getLastName(), woman.getLastName());
        Assert.assertEquals("Doe", woman.getPreviousLastName());
    }
    @Test
    @Parameters({
            "firstNameMan",
            "lastNameMan",
            "ageMan"
    })
    public void testDeregisterPartnership_revertLastName(String firstNameMan , String lasNameMan , int ageMan) {

        Man man = new Man(firstNameMan, lasNameMan ,ageMan);
        woman.registerPartnership(man);

        woman.deregisterPartnership(true);

        Assert.assertNull(woman.getPartner());
        Assert.assertEquals("Doe", woman.getLastName());
        Assert.assertEquals("Jonson", woman.getPreviousLastName());
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void testGetFirstName(Woman woman){
        Assert.assertEquals(woman.getFirstName(),woman.getFirstName(), format("This Woman have incorrect firstname. " + "The firstname should be " + woman.getFirstName()));
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void testGetLastName(Woman woman){
        Assert.assertEquals(woman.getLastName(), woman.getLastName(), format("This Woman have incorrect lastname. " + "The lastname should be " + woman.getLastName()));
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void  testGetAge(Woman woman) {
        Assert.assertEquals(woman.getAge(), woman.getAge(), "This Woman have incorrect age");

    }

    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void testSetFirstName(Woman woman){
        woman.setFirstName(woman.getFirstName());
        Assert.assertEquals(woman.getFirstName(),woman.getFirstName(), format("This Woman have incorrect firstname. " + "The firstname should be " + woman.getFirstName()));
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void testSetLastName(Woman woman){
        woman.setLastName(woman.getLastName()); ;
        Assert.assertEquals(woman.getLastName(), woman.getLastName(), format("This Woman have incorrect lastname. " + "The lastname should be " + woman.getLastName()));
    }
    @Test (dataProvider = "dataWoman", dataProviderClass = TestDataProvider.class)
    public void  testSetAge(Woman woman) {
        woman.setAge(woman.getAge());
        Assert.assertEquals(woman.getAge(), woman.getAge(), "This Woman have incorrect age");

    }
}
