import java.util.Scanner;

public class Grocery {
    final static String STORE_NAME = "Kichmart";

    final static Scanner scanner = new Scanner(System.in);
    static String inputBuffer;

    public static void main(String[] args) {

        println("Welcome to " + STORE_NAME);

        print("We have: ");
        for (String section : Warehouse.sections) {
            print(section + " ");
        }
        println("");
        print("What section are you interested in?: ");

        inputBuffer = scanner.nextLine();
        chooseSection(inputBuffer);
    }

    public static void chooseSection(String sectionName) {
        Product[] chosenSection;
        if (sectionName.equalsIgnoreCase("fruits")) {
            chosenSection = Warehouse.fruits;
        } else if (sectionName.equalsIgnoreCase("vegetables")) {
            chosenSection = Warehouse.vegetables;
        } else if (sectionName.equalsIgnoreCase("diary")) {
            chosenSection = Warehouse.diary;
        } else if (sectionName.equalsIgnoreCase("beverages")) {
            chosenSection = Warehouse.beverages;
        } else {
            println("There is no such section, sweetheart. :(");
            return;
        }

        for (Product product : chosenSection) {
            print(product.getName() + ": " + product.getPricePerUnit() + "$/" + product.getUnit());
        }
        println("");

        // sectionName is a string for instance "fruits"
        print("What " + sectionName + " are you interested in?: ");

        inputBuffer = scanner.nextLine();
        Product product = Warehouse.getProductByName(inputBuffer, chosenSection);

        // println("Do you want to add this to you cart? ");

        // if (input.equalsIgnoreCase("yes")) {

        // } else if (input.equalsIgnoreCase("no")) {

        // } else {
        // println("I can only take yes or no as an answear.");
        // }

    }

    private static void println(String s) {
        System.out.println("" + s);
    }

    private static void print(String s) {
        System.out.print("" + s);
    }
}