package java_string_and_dates.model;

public record Transaction(
        String transactionDescription,
        double transactionValue,
        TransactionType transactionType,
        String transactionDate
) {
}