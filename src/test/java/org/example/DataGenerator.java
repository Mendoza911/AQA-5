package org.example;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift, String pattern) {
        LocalDate now = LocalDate.now();
        String date = now.plusDays(shift).format(DateTimeFormatter.ofPattern(pattern));

        return date;
    }

    public static String generateCity(String locale) {
        String[] city = new String[]{"Москва", "Новосибирск", "Казань", "Омск", "Омск"};
        Random rnd = new Random();
        int mIndex = rnd.nextInt(city.length);

        return city[mIndex];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().subscriberNumber(11);
        return "+" + phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            String city = generateCity("ru");
            String name = generateName("ru");
            String phone = generatePhone("ru");
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
