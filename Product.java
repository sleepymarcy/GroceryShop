import java.net.http.HttpResponse.PushPromiseHandler;

public class Product {
    private String name;
    private double pricePerUnit;
    private String unit;

    Product(String name, double pricePerUnit, String unit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
