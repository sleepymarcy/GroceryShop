public class Bundle {
    private Product product;
    private double amount;

    public Bundle(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    public double totalPrice() {
        return product.getPricePerUnit() * amount;
    }
}
