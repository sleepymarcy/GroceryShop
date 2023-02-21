import java.util.Scanner;

public class Grocery {
    final static String STORE_NAME = "Kichmart";

    final static String[] sections = {
            "fruits", "vegetables", "diary", "beverages"
    };

    final static String[] fruits = {
            "banana", "apple", "orange", "kiwi", "lemon",
            "melon", "papaya", "peach", "pear", "plum",
            "grapes", "watermelon", "pineapple", "strawberry", "lychee"
    };
    final static double[] fruitPrices = {
            7, 2, 5, 8, 2,
            6, 7, 4, 9, 11,
            5, 6, 2, 1, 12
    };

    final static String[] vegetables = {
            "potato", "tomato", "poe-tatoh", "toe-matoh"
    };
    final static double[] vegetablePrices = {
            2, 2, 4, 4
    };

    final static String[] diary = {
            "cheese", "milk", "butter"
    };
    final static double[] diaryPrices = {
            4, 1, 5
    };

    final static String[] beverages = {
            "Fizzy Bublech", "orange juice", "sparkling water"
    };
    final static double[] beveragesPrices = {
            3, 2, 1
    };

    final static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {

        println("Welcome to " + STORE_NAME);

        print("We have: ");
        for (String section : sections) {
            print(section + " ");
        }
        println("");
        print("What section are you interested in?: ");

        input = scanner.nextLine();
        chooseSection(input);
    }

    public static void chooseSection(String s) {
        String[] chosenSection;
        double[] chosenSectionPrices;
        if (s.toLowerCase().equals("fruits")) {
            chosenSection = fruits;
            chosenSectionPrices = fruitPrices;
        } else if (s.toLowerCase().equals("vegetables")) {
            chosenSection = vegetables;
            chosenSectionPrices = vegetablePrices;
        } else if (s.toLowerCase().equals("diary")) {
            chosenSection = diary;
            chosenSectionPrices = diaryPrices;
        } else if (s.toLowerCase().equals("beverages")) {
            chosenSection = beverages;
            chosenSectionPrices = beveragesPrices;
        } else {
            println("There is no such section, sweetheart. :(");
            return;
        }

        for (String e : chosenSection) {
            print(e + " ");
        }
        println("");

        print("What " + s + " are you interested in?: ");

        input = scanner.nextLine();
        int i = getIndexOf(input, chosenSection);        
        println(chosenSection[i] + " costs: " + chosenSectionPrices[i] + " $.");

    }

    public static int getIndexOf(String s, String[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (s.toLowerCase().equals(arr[i].toLowerCase())) {
                break;
            }
            i++;
        }
        return i;
    }

    private static void println(String s) {
        System.out.println("" + s);
    }

    private static void print(String s) {
        System.out.print("" + s);
    }
}