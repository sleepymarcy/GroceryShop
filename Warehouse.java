public class Warehouse {

    final static String[] sections = {
            "Fruits", "Vegetables", "Diary", "Beverages"
    };

    final static Product[] fruits = {
            new Product("Banana", 2, "kg"),
            new Product("Apple", 1, "kg"),
            new Product("Orange", 3, "kg")
    };

    // For later refference:
    // "banana", "apple", "orange", "kiwi", "lemon",
    // "melon", "papaya", "peach", "pear", "plum",
    // "grapes", "watermelon", "pineapple", "strawberry", "lychee"

    final static Product[] vegetables = {
            new Product("Potato", 2, "kg"),
            new Product("Tomato", 2, "kg"),
            new Product("Poe-tatoh", 4, "kg"),
            new Product("Toe-matoh", 4, "kg")
    };

    final static Product[] diary = {
            new Product("Packed cheese", 4, "unit (150g)"),
            new Product("Milk", 1, "bottle (1l)"),
            new Product("Butter", 5, "unit (250g)")
    };

    final static Product[] beverages = {
            new Product("Boodelooap", 4, "bottle (750ml)"),
            new Product("Fizzy Bublech", 3, "bottle (750ml)"),
            new Product("Gummi Berry Juice", 5, "bottle (330ml)"),
            new Product("Bloodwine", 14, "bottle (761ml)"),
            new Product("Magic Potion (by Druid Panoramix) Shot", 700, "can (70ml)")
    };

    public static Product getProductByName(String name, Product[] section) {
        Product chosenProduct = null;
        for (Product product : section) {
            if (product.getName().equalsIgnoreCase(name)) {
                chosenProduct = product;
                break;
            }
        }
        return chosenProduct;
    }
}