package po81.kartashova.oop.model;

public class Service {

    public static final String DEFAULT_NAME = "100 мб сек";
    public static final int DEFAULT_PRICE = 300;

    String name;
    int price;

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Service() {
        this.name = DEFAULT_NAME;
        this.price = DEFAULT_PRICE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
