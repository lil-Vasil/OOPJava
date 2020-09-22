package po81.kartashova.oop.model.account;

import po81.kartashova.oop.model.Service;
import po81.kartashova.oop.model.tariff.IndividualsTariff;
import po81.kartashova.oop.model.tariff.Tariff;

public class EntityAccount implements Account {

    public static final String DEFAULT_SERVICE_NAME = "Интернет 100мб\'сек";

    private Tariff tariff;
    private String entityPerson;
    private int number;

    public EntityAccount(int number, String entityPerson) {
        this.entityPerson = entityPerson;
        tariff = new IndividualsTariff(1);
        tariff.addService(new Service(DEFAULT_SERVICE_NAME, 300));

    }

    public EntityAccount(int number, String entityPerson, Tariff tariff) {
        this.number = number;
        this.entityPerson = entityPerson;
        this.tariff = tariff;
    }

    public String getPerson() {
        return entityPerson;
    }

    public void setEntityPerson(String entityPerson) {
        this.entityPerson = entityPerson;
    }

    @Override
    public int getNumber() {
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
