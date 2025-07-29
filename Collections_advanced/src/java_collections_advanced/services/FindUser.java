package java_collections_advanced.services;

import java_collections_advanced.model.User;
import java.util.*;

public class FindUser {
    MenuNavigator menuNavigator = new MenuNavigator();

//    Поля
    Map<Integer, User> users = new TreeMap<>();

//    Методы
    public void addUser() {
        Scanner scanner = new Scanner(System.in);

//        Получение данных
        System.out.println();
        System.out.print("Введите номер паспорта: ");
        int passportId = (int) (scanner.nextDouble());
        scanner.nextLine();

        if (users.get(passportId) == null) {
            System.out.print("Введите имя человека: ");
            String name = scanner.nextLine();

            System.out.print("Введите возраст человека: ");
            int age = (int) (scanner.nextDouble());
            scanner.nextLine();

            if (age < 0) {
                System.out.println("- Человек еще не родился! Невозможно внести данные в базу");
                menuNavigator.checkOption(this);
                return;
            }

//            Добавление нового пользователя
            User newUser = new User(passportId, name, age);
            users.put(passportId, newUser);
            menuNavigator.checkOption(this);
            System.out.println("- Данные успешно добавлены в базу!");
        } else {
            System.out.println("- Данный паспорт уже есть в базе!");
            menuNavigator.checkOption(this);
        }
    }
}
