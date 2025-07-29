package java_collections_advanced.services;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuNavigator {
    boolean isSelectedOption = false;

//    Методы
    public String showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите команду: ");
        String selectedOption = scanner.nextLine();
        String optionToLowerCase = selectedOption.toLowerCase();

        return optionToLowerCase;
    }

    public void checkOption(FindUser findUser) {
        String selectedOption = showMenu();

        while (!isSelectedOption) {
            switch (selectedOption) {
                case "in":
                    findUser.optionIn();
                    isSelectedOption = true;
                    break;
                case "del":
                    findUser.optionDel();
                    isSelectedOption = true;
                    break;
                case "count":
                    findUser.optionCount();
                    isSelectedOption = true;
                    break;
                case "avg":
                    findUser.optionAvg();
                    isSelectedOption = true;
                    break;
                case "median":
                    findUser.optionMedian();
                    isSelectedOption = true;
                    break;
                case "young":
                    findUser.optionYoung();
                    isSelectedOption = true;
                    break;
                case "old":
                    System.out.println();
                    isSelectedOption = true;
                    break;
                case "print":
                    System.out.println("Выбрана опция: " + selectedOption);
                    isSelectedOption = true;
                    break;
                case "help":
                    System.out.println("Выбрана опция: " + selectedOption);
                    isSelectedOption = true;
                    break;
                case "exit":
                    System.out.println("Выбрана опция: " + selectedOption);
                    isSelectedOption = true;
                    break;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова");
                    checkOption(findUser);
                    break;
            }
        }
    }
}
