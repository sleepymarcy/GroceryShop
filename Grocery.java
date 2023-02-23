import java.util.Dictionary;
import java.util.Scanner;

public class Grocery {
    final static String STORE_NAME = "Kichmart";

    final static Scanner scanner = new Scanner(System.in);
    static String inputBuffer;

    static Cart cart = new Cart();

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
        if (sectionName.equalsIgnoreCase("Fruits")) {
            chosenSection = Warehouse.fruits;
        } else if (sectionName.equalsIgnoreCase("Vegetables")) {
            chosenSection = Warehouse.vegetables;
        } else if (sectionName.equalsIgnoreCase("Diary")) {
            chosenSection = Warehouse.diary;
        } else if (sectionName.equalsIgnoreCase("Beverages")) {
            chosenSection = Warehouse.beverages;
        } else {
            println("There is no such section, sweetheart. :(");
            return;
        }

        for (Product product : chosenSection) {
            println(product.getName() + ": " + product.getPricePerUnit() + "$/" + product.getUnit());
        }
        println("");

        // sectionName is a string for instance "fruits"
        print("What " + sectionName + " are you interested in?: ");

        inputBuffer = scanner.nextLine();
        Product product = Warehouse.getProductByName(inputBuffer, chosenSection);
        if (product != null) {
            println(product.getName() + ": " + product.getPricePerUnit() + "$/" + product.getUnit());
            print("How much/many of it you need?: ");

            // TODO: make it safe
            double quantity = scanner.nextDouble();
            Bundle bundle = new Bundle(product, quantity);
            cart.add(bundle);

        } else {
            print("I'm sorry but there is no such product.");
        }

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