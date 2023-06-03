package dataproviders;

import models.PersonAge;
import models.PersonMan;
import models.PersonWoman;
import org.testng.annotations.DataProvider;

import java.util.Objects;

import static utils.CvsReader.getListObjectsFromCsv;

public class TestDataProvider {

private static final String AGEPATH = "src/test/resources/dataAge.csv";
private static final String NAMEWOMANPATH = "src/test/resources/dataNameWoman.csv";
private static final String NAMEMANPATH = "src/test/resources/dataNameMan.csv";
    @DataProvider(name = "personAge")
    public  static Object[][] personAge(){
//        List<Number> numbers = getListObjectsFromCsv();
//        Object[][] objects = new Object[numbers.size()][];
//        for (int i = 0; i < numbers.size(); i++ ){
//            objects[i][0] = numbers.get(i).getNum1();
//        }
//      return objects;
        return getListObjectsFromCsv(AGEPATH, PersonAge.class).stream().map(personAge -> new Object[]{personAge.getNum1(), personAge.getNum2()}).toArray(Objects[][]::new);
    }

    @DataProvider(name = "personNameWoman")
    public  static Object[][] personNameWoman(){
        return getListObjectsFromCsv(NAMEWOMANPATH, PersonWoman.class).stream().map(personWoman -> new Object[]{personWoman.getFirstName(),personWoman.getLastname()}).toArray(Objects[][]::new);
    }
    @DataProvider(name = "personNameMan")
    public  static Object[][] symbol(){
        return getListObjectsFromCsv(NAMEMANPATH, PersonMan.class).stream().map(personMan -> new Object[]{personMan.getFirstName(), personMan.getLastName()}).toArray(Objects[][]::new);
    }
}
