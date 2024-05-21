package org.krism.utils;

public class ConvertUtils {

    public static String convertType(String databaseValue) {
        String result = "";
        if (databaseValue.equals("Economy")) {
            result = "Эконом";
        } else if (databaseValue.equals("Normal")) {
            result = "Обычный";
        } else if (databaseValue.equals("Vip")) {
            result = "VIP";
        }
        return result;
    }

    public static String convertCapacity(String databaseValue) {
        String result = "";
        if (databaseValue.equals("Single")) {
            result = "Одиночный";
        } else if (databaseValue.equals("Double")) {
            result = "Двое";
        } else if (databaseValue.equals("Triple")) {
            result = "Трое";
        }
        return result;
    }
}
