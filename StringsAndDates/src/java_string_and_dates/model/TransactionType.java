package java_string_and_dates.model;

public enum TransactionType {
//    Константные выражения
    INCOME,
    EXPENSES;

//    Методы
    public static boolean checkTransactionType(String type) {
        String typeUpperCase = type.toUpperCase();

        for (TransactionType i : TransactionType.values()) {
            if (i.name().equals(typeUpperCase)) {
                return true;
            }
        }

        return false;
    }
}
