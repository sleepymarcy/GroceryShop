public class Cart {
    // TODO: when I learn about dynamic collections...
    Bundle[] bundles = new Bundle[100];

    public double getTotal() {
        double total = 0.0;
        for (Bundle bundle : bundles) {
            total += bundle.getTotal();
        }

        return total;
    }
}
