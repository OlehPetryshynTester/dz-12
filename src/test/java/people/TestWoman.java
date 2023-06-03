package people;

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
@Test

    public void testPeopleHaveRetired() {

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
    @Test
    public void testGetFirstName(){
        Assert.assertEquals(woman.getFirstName(),"Jane", format("This Woman have incorrect firstname. " + "The firstname should be " + woman.getFirstName()));
    }
    @Test
    public void testGetLastName(){
        Assert.assertEquals(woman.getLastName(), "Doe", format("This Woman have incorrect lastname. " + "The lastname should be " + woman.getLastName()));
    }
    @Test
    public void  testGetAge() {
        Assert.assertEquals(woman.getAge(), 60, "This Woman have incorrect age");

    }

    @Test
    public void testSetFirstName(){
        woman.setFirstName("Loly");
        Assert.assertEquals(woman.getFirstName(),"Loly", format("This Woman have incorrect firstname. " + "The firstname should be " + woman.getFirstName()));
    }
    @Test
    public void testSetLastName(){
        woman.setLastName("Loly") ;
        Assert.assertEquals(woman.getLastName(), "Loly", format("This Woman have incorrect lastname. " + "The lastname should be " + woman.getLastName()));
    }
    @Test
    public void  testSetAge() {
        woman.setAge(60);
        Assert.assertEquals(woman.getAge(), 60, "This Woman have incorrect age");

    }
}
