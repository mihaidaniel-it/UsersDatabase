package java_string_and_dates.services;

import java.util.Scanner;

public class UserMenu {
    static UserOption userOption;
    private static boolean hasPrinted = false;

//    Методы
    public static void selectMenuOption() {
//        Создание объекта
        FinancialAccounting financialAccounting = new FinancialAccounting();
        Scanner scanner = new Scanner(System.in);

//        Вывод первичной строки о помощи при запуске
        if (hasPrinted) {
            System.out.println(" ");
        } else if (!hasPrinted) {
            System.out.println("Команда 'HELP' - выведет инструкции по пользованию");
            hasPrinted = true;
        }

//        Получение данных
        System.out.print("Введите команду для выполнения операций: ");
        String selectedOption = scanner.nextLine();

       UserOption verifyOption = UserOption.checkUserOption(selectedOption);

        if (verifyOption == null) {
            financialAccounting.addTransaction();
        } else {
            switch (verifyOption) {
                case HELP -> helpOptionMenu();
                case REPORT -> System.out.println("Была введена команда REPORT");
                case EXIT -> System.out.println("Была введена команда EXIT");
            }
        }
    }

    public static void helpOptionMenu() {
        System.out.println(" ");
        System.out.println("Инструкция по использованию приложения:");
        System.out.println("Команда  'HELP' - позволяет получить помощь по приложению");
        System.out.println("Команда  'REPORT' - покажет ваш отчет по финансам");
        System.out.println("Команда  'EXIT' - закроет приложение и покажет ваш отчет по финансам");
        System.out.println("Если вы хотите добавить новую транзакцию, в поле ввода команды нажмите Enter");

        selectMenuOption();
    }
}
