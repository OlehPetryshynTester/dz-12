package people;

import dataproviders.TestDataProvider;
import org.people.Man;
import org.people.Person;
import org.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static java.lang.String.format;


public class TestWoman {
    Person partner = new Man("John" , "Jonson" , 65);




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

    public void testRegisterPartnership() {
        SoftAssert softAssert = new SoftAssert();
        woman.setLastName(woman.getLastName());
        woman.setFirstName(woman.getFirstName());


        partner.setLastName("Smith");
        partner.setFirstName("John");

        woman.registerPartnership(partner);

        softAssert.assertEquals(partner, woman.getPartner());
        softAssert.assertEquals(partner.getLastName(), woman.getLastName());
        softAssert.assertEquals("Doe", woman.getPreviousLastName());
        softAssert.assertAll();
    }
    @Test

    public void testDeregisterPartnershipRevertLastName() {
        SoftAssert softAssert = new SoftAssert();

        woman.registerPartnership(partner);

        woman.deregisterPartnership(true);

        softAssert.assertNull(woman.getPartner());
        softAssert.assertEquals("Doe", woman.getLastName());
        softAssert.assertEquals("Jonson", woman.getPreviousLastName());
        softAssert.assertAll();
    }
    @Test (dataProvider = "womanDataProviderFirstName", dataProviderClass = TestDataProvider.class)
    public void testGetFirstName(Woman woman, String expectedFirstName){
        Assert.assertEquals(woman.getFirstName(),expectedFirstName, format("This Woman have incorrect firstname. " + "The firstname should be " + expectedFirstName));
    }
    @Test (dataProvider = "womanDataProviderLastName", dataProviderClass = TestDataProvider.class)
    public void testGetLastName(Woman woman, String expectedLastName){
        Assert.assertEquals(woman.getLastName(),  expectedLastName, format("This Woman have incorrect lastname. " + "The lastname should be " + expectedLastName));
    }
    @Test (dataProvider = "womanDataProviderAge",dataProviderClass = TestDataProvider.class)
    public void  testGetAge(Woman woman ,int expectedAge) {
        Assert.assertEquals(woman.getAge(), expectedAge, "This Woman have incorrect age" + expectedAge);

    }

    @Test
    public void testSetFirstName(){
        String[] firstNames = {"John", "Jane", "David", "Emily", "Michael"};
        Random random = new Random();
        String randomFirstNames = firstNames[random.nextInt(firstNames.length)];
        woman.setFirstName(randomFirstNames);
        Assert.assertEquals(woman.getFirstName(),randomFirstNames, format("This Woman have incorrect firstname. " + "The firstname should be " + randomFirstNames));
    }
    @Test
    public void testSetLastName(){
        String[] lastNames = {"Cook","Mickle","Green","Jones","mazafaka"};
        Random random = new Random();
        String randomLastNames = lastNames[random.nextInt(lastNames.length)];
        woman.setLastName(randomLastNames) ;
        Assert.assertEquals(woman.getLastName(), randomLastNames, format("This Woman have incorrect lastname. " + "The lastname should be " + randomLastNames));
    }
    @Test
    public void  testSetAge() {
        int newAge = new Random().nextInt(100);
        woman.setAge(newAge);;
        Assert.assertEquals(woman.getAge(), newAge, "This Woman have incorrect age");

    }
}
