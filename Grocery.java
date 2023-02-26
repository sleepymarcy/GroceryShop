import java.util.Scanner;

public class Grocery {
    static final String STORE_NAME = "Kichmart";
    static final String CHECKOUT_PROMPT = "(If you want to checkout type \"checkout\"): ";
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
                println("What section are you interested in?");
                print(CHECKOUT_PROMPT);

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
                println("What " + sectionName.toLowerCase() + " are you interested in?: ");
                println("(If nothing caught your eye type \"none\"");
                print(CHECKOUT_PROMPT);

                productName = scanner.nextLine();
                if (productName.equalsIgnoreCase(CHECKOUT_STR)) {
                    checkout = true;
                } else if (productName.equalsIgnoreCase("none")) {
                    // TODO: Figure out what to do in this situation (this is placeholder for a feature)
                    break;
                }
                chosenProduct = Warehouse.getProductByName(productName, chosenSection);
            }

            Double chosenAmount = null;
            String givenNum = null;
            while (!checkout && chosenAmount == null && chosenProduct != null) {
                println(chosenProduct.getName() + ": " + chosenProduct.getPricePerUnit() + "$/" +
                        chosenProduct.getUnit());
                println("How much/many of it you need?: ");
                println("(If that was a mistake type \"return\")");
                print(CHECKOUT_PROMPT);

                givenNum = scanner.nextLine();

                Bundle bundle;
                try {
                    chosenAmount = Double.parseDouble(givenNum);
                    bundle = new Bundle(chosenProduct, chosenAmount);
                    cart.add(bundle);
                } catch (Exception e) {
                    if (givenNum.equalsIgnoreCase("return")) {
                        // TODO: Figure out what to do in this situation (this is placeholder for a feature)
                        break;
                    } else if (givenNum.equalsIgnoreCase(CHECKOUT_STR)) {
                        checkout = true;
                    }
                }
            }
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