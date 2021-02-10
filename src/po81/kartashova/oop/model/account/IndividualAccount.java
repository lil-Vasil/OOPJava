package po81.kartashova.oop.model.account;

import po81.kartashova.oop.model.Person;
import po81.kartashova.oop.model.Service;
import po81.kartashova.oop.model.ServiceTypes;
import po81.kartashova.oop.model.tariff.IndividualsTariff;
import po81.kartashova.oop.model.tariff.Tariff;

public class IndividualAccount extends AbstractAccount {

    public static final String DEFAULT_SERVICE_NAME = "Интернет 100мб\'сек";
    private static final ServiceTypes type = ServiceTypes.INTERNET;

    private Tariff tariff;
    private Person person;
    private long number;

    public IndividualAccount(long number, Person person) {
        this.number = number;
        this.person = person;
        tariff = new IndividualsTariff(1);
        tariff.addService(new Service(type, DEFAULT_SERVICE_NAME, 100));
    }

    public IndividualAccount(long number, Person person, Tariff tariff) {
        super(number, tariff);
        this.person = person;
    }

    public long getNumber() {
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