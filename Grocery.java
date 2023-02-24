import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class Grocery {
    final static String STORE_NAME = "Kichmart";
    static boolean checkout = false;

    final static Scanner scanner = new Scanner(System.in);
    static String inputBuffer = null;

    static Cart cart = new Cart();

    public static void main(String[] args) {
        println("Welcome to " + STORE_NAME);

        while (!checkout) {

            // choose section or checkout
            Product[] chosenSection = null;
            String articles = null;
            while (chosenSection == null) {
                print("We have: ");
                for (String section : Warehouse.sections) {
                    print(section + " ");
                }
                println("");
                println("What section are you interested in?");
                print("(If you want to checkout type \"checkout\"): ");

                articles = scanner.nextLine();
                if (articles.equalsIgnoreCase("checkout")) {
                    checkout = true;
                }
                chosenSection = getSection(articles);
            }

            // choose product or checkout
            Product chosenProduct = null;
            // TODO: find out if this is doable in a smarter manner
            while (!inputBuffer.equalsIgnoreCase("none") && !inputBuffer.equalsIgnoreCase("checkout")
                    && !articles.equalsIgnoreCase("checkout")
                    && chosenProduct == null) {
                println("We have: ");
                for (Product product : chosenSection) {
                    println(product.getName() + ": " + product.getPricePerUnit() + "$/" +
                            product.getUnit());
                }
                println("");
                println("What " + articles.toLowerCase() + " are you interested in?: ");
                println("(If nothing caught your eye type \"none\"");
                print("(If you want to checkout type \"checkout\"): ");

                inputBuffer = scanner.nextLine();
                if (inputBuffer.equalsIgnoreCase("checkout")) {
                    checkout = true;
                }
                chosenProduct = Warehouse.getProductByName(inputBuffer, chosenSection);
            }

            println(chosenProduct.getName() + ": " + chosenProduct.getPricePerUnit() + "$/" +
                    chosenProduct.getUnit());
            print("How much/many of it you need?: ");

            // TODO: make it safe
            inputBuffer = scanner.nextLine();
            double quantity = Double.parseDouble(inputBuffer);
            Bundle bundle = new Bundle(chosenProduct, quantity);
            cart.add(bundle);

            print("Is that all from this section?: ");

            // inputBuffer = scanner.nextLine();
            // if (inputBuffer.equalsIgnoreCase("Yes")) {
            // break;

            // } else if (inputBuffer.equalsIgnoreCase("No")) {
            // // return to "What sectionName are you interested in?"
            // } else {
            // println("I'm sorry but I can only respond to Yes or No.");
            // // return to "Is that all from this section?"
            // }

            // } else {
            // print("I'm sorry but there is no such product.");
            // }
            // }
            // print("Need more stuff?: ");
            // inputBuffer = scanner.nextLine();
            // if (inputBuffer.equalsIgnoreCase("Yes")) {
            // // return to "What section are you interested in?"
            // } else if (inputBuffer.equalsIgnoreCase("No")) {
            // break;
            // }
        }
        // double total = cart.getTotal();
        // println("Total amount is: " + total + "$.");
    }

    static Product[] getSection(String sectionName) {
        if (sectionName.equalsIgnoreCase("Fruits")) {
            return Warehouse.fruits;
        } else if (sectionName.equalsIgnoreCase("Vegetables")) {
            return Warehouse.vegetables;
        } else if (sectionName.equalsIgnoreCase("Diary")) {
            return Warehouse.diary;
        } else if (sectionName.equalsIgnoreCase("Beverages")) {
            return Warehouse.beverages;
        } else {
            return null;
        }
    }

    private static void println(String s) {
        System.out.println("" + s);
    }

    private static void print(String s) {
        System.out.print("" + s);
    }
}