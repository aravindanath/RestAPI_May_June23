package day2;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Generic {

    public static String firstName(){
        Faker faker = new Faker();
       return faker.name().firstName();
    }

    public static String lastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String email(){
        Faker faker = new Faker();
        return faker.name().firstName().replace(" ","")+"@testmail.com";
    }

    public static String birthdate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }


    public static String phone(){
        Faker faker = new Faker();
        return faker.number().digits(10);
    }

    public static String address(){
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }

    public static String streetName(){
        Faker faker = new Faker();
        return faker.address().streetName();
    }

    public static String city(){
        Faker faker = new Faker();
        return faker.address().city();
    }

    public static String stateProvince(){
        Faker faker = new Faker();
        return faker.address().state();
    }

    public static String pincode(){
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String country(){
        Faker faker = new Faker();
        return faker.address().country();
    }
}
