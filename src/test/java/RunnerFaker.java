import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class RunnerFaker {
    public static void main(String[] args) {
        Locale locale = new Locale("en-IND"); // It will generate India specific data.
        Faker faker = new Faker(locale);
        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String email = faker.internet().emailAddress();
        System.out.println("The Name is : " + fullName);
        System.out.println("The First Name is : " + firstName);
        System.out.println("The Last Name is : " + lastName);
        System.out.println("The Address is : " + address);
        System.out.println("The Address is : " + phoneNumber);
        System.out.println("The EMail is : " + email);
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-IND"),new RandomService());
        String alphaEmail = fakeValuesService.bothify("#???##@gmail.com");
        System.out.println("aplhaEmails "+alphaEmail);
        Matcher match = Pattern.compile("[0-9][a-zA-z]{3}[0-9]{2}@gmail.com").matcher(alphaEmail);
        System.out.println("match "+match);
    }
}