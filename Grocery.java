import java.util.Scanner;

public class Grocery {
    static final String STORE_NAME = "Kichmart";
    static final String CHECKOUT_PROMPT = "(If you want to checkout type \"checkout\")";
    static final String CHECKOUT_STR = "checkout";
    static boolean checkout = false;

    static final Scanner scanner = new Scanner(System.in);
    static String inputBuffer = null;

    static Cart cart = new Cart();

    public static void main(String[] args) {
        println("Welcome to " + STORE_NAME);

        while (!checkout) {

            // choose section or checkout
            Product[] chosenSection = null;
            String sectionName = null;
            while (!checkout && chosenSection == null) {
                print("We have: ");
                for (String section : Warehouse.sections) {
                    print(section + " ");
                }
                println("");
                println("");
                println(CHECKOUT_PROMPT);
                print("What section are you interested in?: ");

                sectionName = scanner.nextLine();
                if (sectionName.equalsIgnoreCase(CHECKOUT_STR)) {
                    checkout = true;
                }
                chosenSection = getSection(sectionName);
            }

            // choose product or checkout
            Product chosenProduct = null;
            String productName = null;
            while (!checkout && chosenProduct == null) {
                println("We have: ");
                for (Product product : chosenSection) {
                    println(product.getName() + ": " + product.getPricePerUnit() + "$/" +
                            product.getUnit());
                }
                println("");
                println("(If nothing caught your eye type \"none\")");
                println(CHECKOUT_PROMPT);
                print("What " + sectionName.toLowerCase() + " are you interested in?: ");

                productName = scanner.nextLine();
                if (productName.equalsIgnoreCase(CHECKOUT_STR)) {
                    checkout = true;
                } else if (productName.equalsIgnoreCase("none")) {
                    // TODO: Figure out what to do in this situation (this is placeholder for a
                    // feature)
                    break;
                }
                chosenProduct = Warehouse.getProductByName(productName, chosenSection);
            }

            Double chosenAmount = null;
            String givenNum = null;
            while (!checkout && chosenAmount == null && chosenProduct != null) {
                println(chosenProduct.getName() + ": " + chosenProduct.getPricePerUnit() + "$/" +
                        chosenProduct.getUnit());
                println("");
                println("(If that was a mistake type \"return\")");
                println(CHECKOUT_PROMPT);
                print("How much/many of it you need?: ");

                givenNum = scanner.nextLine();

                Bundle bundle;
                try {
                    chosenAmount = Double.parseDouble(givenNum);
                    bundle = new Bundle(chosenProduct, chosenAmount);
                    cart.add(bundle);
                } catch (Exception e) {
                    if (givenNum.equalsIgnoreCase("return")) {
                        // TODO: Figure out what to do in this situation (this is placeholder for a
                        // feature)
                        break;
                    } else if (givenNum.equalsIgnoreCase(CHECKOUT_STR)) {
                        checkout = true;
                    }
                }
            }
        }
        double total = cart.getTotal();
        println("");
        println("Total amount is: " + total + "$.");
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