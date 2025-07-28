package java_collections_advanced.services;

import java.util.Scanner;

public class MenuNavigator {
//    Методы
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите команду: ");
        String selectedOption = scanner.nextLine();
        checkOption(selectedOption);
    }

    public void checkOption(String option) {
        String optionToLowerCase = option.toLowerCase();

        switch (optionToLowerCase) {
            case "in" -> System.out.println("Выбрана опция " + optionToLowerCase);
            case "del" -> System.out.println("Выбрана опция " + option);
            case "count" -> System.out.println("Выбрана опция " + option);
            case "avg" -> System.out.println("Выбрана опция " + option);
            case "median" -> System.out.println("Выбрана опция " + option);
            case "young" -> System.out.println("Выбрана опция " + option);
            case "old" -> System.out.println("Выбрана опция " + option);
            case "print" -> System.out.println("Выбрана опция " + option);
            case "help" -> System.out.println("Выбрана опция " + option);
            case "exit" -> System.out.println("Выбрана опция " + option);
            default -> System.out.println("Неизвестная команда. Попробуйте снова");
        }
    }
}
