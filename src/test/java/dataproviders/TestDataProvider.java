package dataproviders;

import models.PersonDataMan;
import models.PersonDataWoman;
import org.people.Man;
import org.people.Woman;
import org.testng.annotations.DataProvider;

import static utils.CvsReader.getListObjectsFromCsv;

public class TestDataProvider {

private static final String RETIRED_MEN_PATH = "src/test/resources/RETIRED_MEN_PATH.csv";
private static final String RETIRED_WOMEN_PATH = "src/test/resources/RETIRED_WOMEN_PATH.csv";
private static final String NAMEMANPATH = "src/test/resources/dataNameMan.csv";
//    @DataProvider(name = "personAge")
//    public  static Object[][] personAge(){
////        List<Number> numbers = getListObjectsFromCsv();
////        Object[][] objects = new Object[numbers.size()][];
////        for (int i = 0; i < numbers.size(); i++ ){
////            objects[i][0] = numbers.get(i).getNum1();
////        }
////      return objects;
//        return getListObjectsFromCsv(AGEPATH, PersonAge.class).stream().map(personAge -> new Object[]{personAge.getNum1(), personAge.getNum2()}).toArray(Objects[][]::new);
//    }
//
//    @DataProvider(name = "personNameWoman")
//    public  static Object[][] personNameWoman(){
//        return getListObjectsFromCsv(NAMEWOMANPATH, PersonWoman.class).stream().map(personWoman -> new Object[]{personWoman.getFirstName(),personWoman.getLastname()}).toArray(Objects[][]::new);
//    }
//    @DataProvider(name = "personNameMan")
//    public  static Object[][] symbol() {
//        return getListObjectsFromCsv(NAMEMANPATH, PersonMan.class).stream().map(personMan -> new Object[]{personMan.getFirstName(), personMan.getLastName()}).toArray(Objects[][]::new);
//
//    }
        @DataProvider(name = "dataMan")
        public static Object[] verifyDataMan() {
            return getListObjectsFromCsv(RETIRED_MEN_PATH, PersonDataMan.class).stream().map(personMan -> new Man(personMan.getFirstName(), personMan.getLastName(), personMan.getAge())).toArray(Man[]::new);
        }
    @DataProvider(name = "dataWoman")
    public static Object[] verifyDataWoman() {
        return getListObjectsFromCsv(RETIRED_WOMEN_PATH, PersonDataWoman.class).stream().map(personWoman -> new Woman(personWoman.getFirstName(), personWoman.getLastName(), personWoman.getAge())).toArray(Woman[]::new);
    }
    @DataProvider(name = "womanDataProviderAge")
    public static Object[][] womanDataProviderAge() {
        return new Object[][]{
                {new Woman("Jane", "Doe", 43), 43},
                {new Woman("Mary", "Smith", 45), 45}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }
    @DataProvider(name = "womanDataProviderFirstName")
    public static Object[][] womanDataProviderFirstname() {
        return new Object[][]{
                {new Woman("Jane", "Doe", 60), "Jane"},
                {new Woman("Mary", "Smith", 70), "Mary"}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }
    @DataProvider(name = "womanDataProviderLastName")
    public static Object[][] womanDataProviderLast() {
        return new Object[][]{
                {new Woman("Jones", "Doe", 60), "Doe"},
                {new Woman("Tom", "Smith", 70), "Smith"}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }

    @DataProvider(name = "manDataProviderAge")
    public static Object[][] manDataProviderAge() {
        return new Object[][]{
                {new Man("Jones", "Doe", 60), 60},
                {new Man("Tom", "Smith", 70), 70}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }
    @DataProvider(name = "manDataProviderLastName")
    public static Object[][] manDataProviderLastName() {
        return new Object[][]{
                {new Man("Jones", "Doe", 60), "Doe"},
                {new Man("Tom", "Smith", 70), "Smith"}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }
    @DataProvider(name = "manDataProviderFirstName")
    public static Object[][] manDataProviderFirstName() {
        return new Object[][]{
                {new Man("Jones", "Doe", 60), "Jones"},
                {new Man("Tom", "Smith", 70), "Tom"}
                // Додайте додаткові тестові дані, які потрібно перевірити
        };

    }
}
