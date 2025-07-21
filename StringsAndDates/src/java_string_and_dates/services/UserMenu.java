package java_string_and_dates.services;

import java.util.Scanner;
import java_string_and_dates.services.UserOption;

public class UserMenu {
    static UserOption userOption;

//    Методы
    public static void selectMenuOption() {
//        Создание объекта
        Scanner scanner = new Scanner(System.in);

//        Получение данных
        System.out.println("Команда 'HELP' - выведет инструкции по пользованию");
        System.out.print("Введите команду для выполнения операций: ");
        String selectedOption = scanner.nextLine();

       UserOption verifyOption = UserOption.checkUserOption(selectedOption);

        if (verifyOption == null) {
            System.out.println("Добавлениен новой транзакции");
        } else {
            switch (verifyOption) {
                case HELP -> System.out.println("Была введена команда HELP");
                case REPORT -> System.out.println("Была введена команда REPORT");
                case EXIT -> System.out.println("Была введена команда EXIT");
            }
        }
    }
}
