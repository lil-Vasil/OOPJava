package po81.kartashova.oop.model;

public final class Service {

    private static final String DEFAULT_NAME = "100 мб сек";
    private static final int DEFAULT_PRICE = 300;

    ServiceTypes serviceTypes;
    final String name;
    final int price;

    public Service() {
        this.name = DEFAULT_NAME;
        this.price = DEFAULT_PRICE;
        this.serviceTypes = ServiceTypes.INTERNET;
    }

    public Service(ServiceTypes serviceTypes, String name, int price) {
        this.serviceTypes = serviceTypes;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ServiceTypes getServiceTypes() {
        return serviceTypes;
    }
}
