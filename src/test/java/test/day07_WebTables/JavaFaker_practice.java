package test.day07_WebTables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_practice {

    @Test
    public void javaFaker_test(){

        Faker faker = new Faker();

        String name = faker.name().fullName();
        System.out.println("name = " + name);

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress();
        System.out.println("streetAddress = " + streetAddress);

        String gameOfThrones = faker.gameOfThrones().quote();
        System.out.println("gameOfThrones = " + gameOfThrones);

        String chuckNorrisFact = faker.chuckNorris().fact();
        System.out.println("chuckNorrisFact = " + chuckNorrisFact);


    }

}
