package java_string_and_dates.services;

import java_string_and_dates.model.Transaction;
import java_string_and_dates.model.TransactionType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FinancialAccounting {
    //    Объекты
    Scanner scanner = new Scanner(System.in);
    StringBuilder stringBuilder = new StringBuilder();

    //    Поля
    private static Transaction[] lastFiveUserTransactions = new Transaction[5];
    private static int currentTransactionInRow = 0;
    private static int wasAddedTransactions = 0;
    private static double totalIncome = 0;
    private static double totalExpenses = 0;
    private static double balance = 0;

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
        Transaction newTransaction = new Transaction(transactionDescriptionFormatted,
                transactionValue,
                transactionTypeUpperCase,
                formatedDate);

//        Присвоение объекта в массив транзакций
        if (currentTransactionInRow < 5) {
            lastFiveUserTransactions[currentTransactionInRow] = newTransaction;
            currentTransactionInRow++;
            wasAddedTransactions++;

//            Операции со счетом
            if (TransactionType.INCOME == transactionTypeUpperCase) {
                totalIncome += transactionValue;
            } else if (TransactionType.EXPENSES == transactionTypeUpperCase) {
                totalExpenses += transactionValue;
            }

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
            wasAddedTransactions++;

//            Операции со счетом
            if (TransactionType.INCOME == transactionTypeUpperCase) {
                totalIncome += transactionValue;
            } else if (TransactionType.EXPENSES == transactionTypeUpperCase) {
                totalExpenses += transactionValue;
            }

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

    public void reportOption() {
        balance = totalIncome - totalExpenses;

//        Вывод данных по счету
        System.out.println("Отчет по финансам:");
        System.out.println("Общий доход: " + totalIncome);
        System.out.println("Общие расходы: " + totalExpenses);
        System.out.println(String.format("Баланс: %.2f", balance));

//        Вывод транзакций
        System.out.println("Последние транзакции:");

        if (wasAddedTransactions > 0) {
            stringBuilder.append(String.format("%-15s %-10s %-10s %-20s%n", "Дата", "Сумма", "Тип", "Описание"));
            stringBuilder.append("------------------------------------------------------------------\n");

            for (int i = 0; i < lastFiveUserTransactions.length; i++) {
                if (lastFiveUserTransactions[i] != null) {
                    stringBuilder.append(String.format(
                            "%-15s %-10.2f %-10s %-20s%n",
                            lastFiveUserTransactions[i].transactionDate(),
                            lastFiveUserTransactions[i].transactionValue(),
                            lastFiveUserTransactions[i].transactionType(),
                            lastFiveUserTransactions[i].transactionDescription()
                    ));
                }
            }

            String result = stringBuilder.toString();
            System.out.print(result);

            UserMenu.selectMenuOption();
        } else if (wasAddedTransactions == 0) {
            System.out.printf("Вы еще не совершали транзакций");
            UserMenu.selectMenuOption();
        }
    }

    public void exitOption() {
        balance = totalIncome - totalExpenses;

//        Вывод данных по счету
        System.out.println("Отчет по финансам:");
        System.out.println("Общий доход: " + totalIncome);
        System.out.println("Общие расходы: " + totalExpenses);
        System.out.println(String.format("Баланс: %.2f", balance));

//        Вывод отчета
        if (wasAddedTransactions > 0) {
            stringBuilder.append(String.format("%-15s %-10s %-10s %-20s%n", "Дата", "Сумма", "Тип", "Описание"));
            stringBuilder.append("------------------------------------------------------------------\n");

            for (int i = 0; i < lastFiveUserTransactions.length; i++) {
                if (lastFiveUserTransactions[i] != null) {
                    stringBuilder.append(String.format(
                            "%-15s %-10.2f %-10s %-20s%n",
                            lastFiveUserTransactions[i].transactionDate(),
                            lastFiveUserTransactions[i].transactionValue(),
                            lastFiveUserTransactions[i].transactionType(),
                            lastFiveUserTransactions[i].transactionDescription()
                    ));
                }
            }

            String result = stringBuilder.toString();
            System.out.print(result);
        } else if (wasAddedTransactions == 0) {
            System.out.println("Вы еще не совершали транзакций");
        }

        System.out.println("Спасибо, что воспользовались нашим приложением!");
        System.exit(0);
    }
}
