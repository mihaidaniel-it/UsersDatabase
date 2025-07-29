package java_collections_advanced.services;

import java_collections_advanced.model.User;

import java.util.*;

public class FindUser {
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

    public void optionAvg() {
        System.out.println("# Средний возраст людей");

        int allUsers = users.size();
        int sumOfUsersAge = 0;

        if (allUsers == 0) {
            System.out.println("- В базе еше нету никаких данных");
            menuNavigator.checkOption(this);
        }

        for (User user : users.values()) {
            sumOfUsersAge += user.age();
        }

        double averageAge = sumOfUsersAge / allUsers;
        System.out.println("- Средний возраст людей по данным: " + averageAge);
        menuNavigator.checkOption(this);
    }

    public void optionMedian() {
        List<Integer> ages = new ArrayList<>();

        int allUsers = users.size();

        if (allUsers == 0) {
            System.out.println("- В базе еше нету никаких данных");
            menuNavigator.checkOption(this);
        }

        int medianNumber = 0;
        int[] medianNumbers = new int[2];

//        Добавляем все возраста
        for (User user : users.values()) {
            ages.add(user.age());
        }

//        Сортировка от меньшего к большему
        Collections.sort(ages);

        if (allUsers % 2 == 0) {
            int middleIndexEven = (allUsers / 2) - 1;
            medianNumber = ages.get(middleIndexEven);
            System.out.println("- Медиана возраста людей: " + medianNumber);
            menuNavigator.checkOption(this);
        } else if (allUsers % 2 != 0 && allUsers >= 2) {
            int middleIndexNotEve = (int) ((allUsers / 2) - 1);

            medianNumbers[0] = ages.get(middleIndexNotEve);
            medianNumbers[1] = ages.get(middleIndexNotEve + 1);

            System.out.println("- Медиана возраста людей: " + medianNumbers[0] + ", " + medianNumbers[1]);
            menuNavigator.checkOption(this);
        } else {
            System.out.println("- Нельзя получить медиану возраста с одним человека");
            menuNavigator.checkOption(this);
        }
    }

    public void optionYoung() {
        TreeMap<Integer, User> agesToUser = new TreeMap();

        int allUsers = users.size();

        if (allUsers == 0) {
            System.out.println("- В базе еше нету никаких данных");
            menuNavigator.checkOption(this);
        }

        //        Добавляем все возраста
        for (User user : users.values()) {
            agesToUser.put(user.age(), user);
        }

        User user = agesToUser.get(agesToUser.firstKey());

        System.out.println("# Самый молодой человек по базе:");
        System.out.println("Серия паспорта: " + user.passportId());
        System.out.println("Имя: " + user.name());
        System.out.println("Возраст: " + user.age());
        menuNavigator.checkOption(this);
    }

    public void optionOld() {
        TreeMap<Integer, User> agesToUser = new TreeMap();

        int allUsers = users.size();

        if (allUsers == 0) {
            System.out.println("- В базе еше нету никаких данных");
            menuNavigator.checkOption(this);
        }

        //        Добавляем все возраста
        for (User user : users.values()) {
            agesToUser.put(user.age(), user);
        }

        User user = agesToUser.get(agesToUser.lastKey());

        System.out.println("# Самый возрастной человек по базе:");
        System.out.println("Серия паспорта: " + user.passportId());
        System.out.println("Имя: " + user.name());
        System.out.println("Возраст: " + user.age());
        menuNavigator.checkOption(this);
    }

    public void optionPrint() {
        int allUsers = users.size();

        if (allUsers == 0) {
            System.out.println("- В базе еше нету никаких данных");
            menuNavigator.checkOption(this);
        }

        System.out.println("# Все пользователи ");
        for (User user : users.values()) {
            System.out.println("Серия паспорта: " + user.passportId());
            System.out.println("Имя: " + user.name());
            System.out.println("Возраст: " + user.age());

            if (allUsers > 1) {
                System.out.println("--------------------------");
            }
        }

        menuNavigator.checkOption(this);
    }

    public void optionHelp() {
        System.out.println("# Доступные команды");
        System.out.println("in - добавить пользователя");
        System.out.println("del - удалить пользователя");
        System.out.println("count - общее число пользователей");
        System.out.println("avg - средний возраст пользователей");
        System.out.println("median - медиана возрастов пользователй");
        System.out.println("young - самый молодой пользователь");
        System.out.println("old - самый возрастной пользователь");
        System.out.println("print - все пользователи");
        System.out.println("help - доступные команды");
        System.out.println("exit - выход");

        menuNavigator.checkOption(this);
    }
}