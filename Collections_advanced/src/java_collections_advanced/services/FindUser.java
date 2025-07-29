package java_collections_advanced.services;

import java_collections_advanced.model.User;
import java.util.*;

public class FindUser  {
    MenuNavigator menuNavigator = new MenuNavigator();
    Scanner scanner = new Scanner(System.in);

//    Поля
    Map<Integer, User> users = new TreeMap<>();

//    Методы
    public void optionIn() {
//        Получение данных
        System.out.println("# Добавление нового человека в базу");
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
            System.out.println("- Данные успешно добавлены в базу!");
            menuNavigator.checkOption(this);
        } else {
            System.out.println("- Данный паспорт уже есть в базе!");
            menuNavigator.checkOption(this);
        }
    }

    public void optionDel() {
        System.out.println("# Удаление человека из базы");
        System.out.print("Введите номер паспорта: ");
        int passportId = scanner.nextInt();
        scanner.nextLine();

        User user = users.get(passportId);

        if (user.passportId() == passportId) {
            users.remove(passportId);
            System.out.println("- Пользователь с номером паспорта " + passportId + " успешно удален!");
            menuNavigator.checkOption(this);
        } else {
            System.out.println("- Человека с таким номером паспорта нету в базе");
            menuNavigator.checkOption(this);
        }
    }

    public void optionCount() {
        int allUsers = users.size();
        System.out.println("Общее кол-во людей: " + allUsers);
    }
}
