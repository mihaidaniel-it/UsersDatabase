package java_collections_base;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Коллекция: хранение чисел от пользователя
        Map<Integer, Integer> numbersFromUser = new HashMap<>();

        System.out.println("Введите целое число. Для остановки нажмите Enter: ");

        while (true) {
            String input = scanner.nextLine();
//            Обработка пустой строчки
            if (input.isEmpty()) {
                break;
            }

//            Добавление числа
            try {
                int number = Integer.parseInt(input);
                numbersFromUser.put(number, numbersFromUser.getOrDefault(number, 0) + 1);
            } catch (NumberFormatException e) {
                System.out.println("Это не целое число. Введите число еще раз");
            }
        }

        int sumOfUnique = 0;
        List<Integer> duplicates = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : numbersFromUser.entrySet()) {
            if (entry.getValue() == 1) {
                sumOfUnique += entry.getKey();
            } else {
                duplicates.add(entry.getKey());
            }
        }

        System.out.println("\nСумма уникальных чисел: " + sumOfUnique);
        if (!duplicates.isEmpty()) {
            System.out.println("Повторяющиеся числа: " + duplicates);
        } else {
            System.out.println("Повторяющихся чисел нет.");
        }
    }
}