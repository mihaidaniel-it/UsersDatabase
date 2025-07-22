package java_string_and_dates.services;

import java_string_and_dates.model.Transaction;
import java_string_and_dates.model.TransactionType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FinancialAccounting {
    Scanner scanner = new Scanner(System.in);

    Transaction[] lastFiveUserTransactions = new Transaction[5];
    int currentTransactionInRow = 0;

//    Методы
    public String toLowerUpperCase(String description) {
        return description.substring(0, 1).toUpperCase() + description.substring(1).toLowerCase();
    }

    public void addTransaction() {
//        Сканер под английскую версию (дабл через точку)
        scanner.useLocale(Locale.ENGLISH);

//        Получение данных от пользователя
        System.out.println(" ");
        System.out.println("Добавление новой транзакции");
        System.out.print("Описание транзакции: ");
        String transactionDescription = scanner.nextLine();

        System.out.print("Сумма: ");
        Double transactionValue = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Тип транзакции [INCOME/EXPENSES]: ");
        String transactionType = scanner.nextLine();

//        Проверка данных на корректность
        if (transactionDescription.length() < 2 || transactionDescription.length() > 20) {
            System.out.println("Описание транзакции должно быть от 2-х до 20 символов");
            System.out.println(" ");
            addTransaction();
        }

        if (!TransactionType.checkTransactionType(transactionType)) {
            System.out.println("Вы указали неверный тип транзакции. Укажите INCOME/EXPENSES");
            System.out.println(" ");
            addTransaction();
        }

//        Готовые входные данные для истории транзакций
        String transactionDescriptionFormatted = toLowerUpperCase(transactionDescription);
        TransactionType transactionTypeUpperCase = TransactionType.valueOf(transactionType.toUpperCase());
//        Форматирование даты
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formatedDate = today.format(dateFormat);

//        Объект с новой транзакцией
        Transaction newTransaction = new Transaction(
                transactionDescriptionFormatted,
                transactionValue,
                transactionTypeUpperCase,
                formatedDate);

//        Присвоение объекта в массив транзакций
        if (currentTransactionInRow < 5) {
            lastFiveUserTransactions[currentTransactionInRow] = newTransaction;
            currentTransactionInRow++;

//            Вывод транзакции
            System.out.println("Добавлена новая транзакция!");

            String addTransactionText = "%s; %.2f; %s; %s";
            System.out.println(String.format(
                    addTransactionText,
                    transactionDescriptionFormatted,
                    transactionValue,
                    transactionTypeUpperCase,
                    formatedDate));

            System.out.println(" ");
            UserMenu.selectMenuOption();
        } else if (currentTransactionInRow == 5) {
            currentTransactionInRow = 0;
            lastFiveUserTransactions[currentTransactionInRow] = newTransaction;

//            Вывод транзакции
            System.out.println("Добавлена новая транзакция!");

            String addTransactionText = "%s; %.2f; %s; %s";
            System.out.println(String.format(
                    addTransactionText,
                    transactionDescriptionFormatted,
                    transactionValue,
                    transactionTypeUpperCase,
                    formatedDate));

            System.out.println(" ");
            UserMenu.selectMenuOption();
        }
    }
}
