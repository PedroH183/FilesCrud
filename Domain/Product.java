package Domain;

import Service.DataCompatibility;

public class Product implements DataCompatibility {

    String name;
//    Integer price_in_cents;
//    String type = "Product";

    public Product(String name ){
        this.name = name;
//        this.price_in_cents = price_in_cents;
    }

    public void soutData(){
        System.out.println( (this.name + " " + this));
    }

    @Override
    public String getRawData() {
        return name;
    }
}
