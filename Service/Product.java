package Service;

import Domain.DataCompatibility;

public class Product implements DataCompatibility {

    String name;
    Integer price_in_cents;
    String type = "Product";

    public Product(String name, Integer price_in_cents){
        this.name = name;
        this.price_in_cents = price_in_cents;
    }

    @Override
    public String getRawData() {
        return name;
    }
}
