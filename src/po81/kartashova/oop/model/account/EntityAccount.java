package po81.kartashova.oop.model.account;

import po81.kartashova.oop.model.Person;
import po81.kartashova.oop.model.Service;
import po81.kartashova.oop.model.ServiceTypes;
import po81.kartashova.oop.model.tariff.IndividualsTariff;
import po81.kartashova.oop.model.tariff.Tariff;

public class EntityAccount extends AbstractAccount {

    public static final String DEFAULT_SERVICE_NAME = "Интернет 100мб\'сек";
    private static ServiceTypes type = ServiceTypes.INTERNET;
    private Tariff tariff;
    private Person entityPerson;
    private int number;

    public EntityAccount(int number, Person entityPerson) {
        this.entityPerson = entityPerson;
        tariff = new IndividualsTariff(1);
        tariff.addService(new Service(type, DEFAULT_SERVICE_NAME, 300));

    }

    public EntityAccount(int number, Person entityPerson, Tariff tariff) {
        super(number, tariff);
        this.entityPerson = entityPerson;
    }

    public Person getPerson() {
        return entityPerson;
    }

    public void setEntityPerson(Person entityPerson) {
        this.entityPerson = entityPerson;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
