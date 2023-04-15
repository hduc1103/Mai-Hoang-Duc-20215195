import java.util.Scanner;

public class dayofmonth {
    public static void main(String[] args) {
        int days = 0;
        int year = 0;
        String[] monthNames = { "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december" };
        String[] monthAbbreviations = { "jan.", "feb.", "mar.", "apr.", "may.", "jun.", "jul.", "aug.", "sep.", "oct.", "nov.", "dec." };
        String[] in3letters = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };
        String[] monthNumbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        int[] monthLengths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner scanner = new Scanner(System.in);
        boolean validmonth = true;
        while (validmonth) {
            System.out.print("Enter the month: ");
            String month = scanner.next().toLowerCase();
            if (included(monthNames, month)) {
                days = monthLengths[monthindex(monthNames, month)];
            } else if (included(monthAbbreviations, month)) {
                days = monthLengths[monthindex(monthAbbreviations, month)];
            } else if (included(in3letters, month)) {
                days = monthLengths[monthindex(in3letters, month)];
            } else if (included(monthNumbers, month)) {
                int monthNumber = Integer.parseInt(month);
                days = monthLengths[monthNumber - 1];
            } else {
                System.out.println("Invalid month entered. Please try again.");
                continue;
            }
            boolean validyear = true;
            while (validyear) {
                System.out.print("Enter the year: ");
                year = scanner.nextInt();
                if (year <= 0) {
                    System.out.print("Invid year entered. Please try again\n");
                    continue;
                } else {
                    validyear = false;
                }
            }
            if (month.equals("february") || month.equals("feb.") || month.equals("feb") || month.equals("2")) {
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            days = 29;
                        }
                    } else {
                        days = 29;
                    }
                }
            }
        validmonth = false;
        System.out.println("Number of days in " + month + " " + year + ": " + days);
        }
        scanner.close();
    }

    public static boolean included(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    public static int monthindex(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

}