package java_collections_advanced.services;

import java.util.Scanner;

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
                    findUser.optionOld();
                    isSelectedOption = true;
                    break;
                case "print":
                    findUser.optionPrint();
                    isSelectedOption = true;
                    break;
                case "help":
                    findUser.optionHelp();
                    isSelectedOption = true;
                    break;
                case "exit":
                    findUser.optionExit();
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
