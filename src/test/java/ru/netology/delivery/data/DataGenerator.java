package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int daysToAdd) {
        LocalDate date = LocalDate.now();
        LocalDate deliveryDate = date.plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String deliveryDateText = deliveryDate.format(formatter);
        return deliveryDateText;
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String name = lastName + " " + firstName;
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber().replaceAll("[()\\s-]+", "");
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            String city = generateCity(locale);
            String name = generateName(locale);
            String phone = generatePhone(locale);
            var user = new UserInfo(city, name, phone);
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

