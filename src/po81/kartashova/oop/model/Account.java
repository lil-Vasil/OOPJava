package po81.kartashova.oop.model;

public class Account {

    public static final String DEFAULT_SERVICE_NAME = "Интернет 100мб\'сек";

    private Tariff tariff;
    private Person person;
    private int number;

    public Account(int number, Person person) {
        this.number = number;
        this.person = person;
        tariff = new IndividualsTariff(1);
        tariff.addService(new Service(DEFAULT_SERVICE_NAME, 100));
    }

    public Account(int number, Person person, Tariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }

    public int getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
