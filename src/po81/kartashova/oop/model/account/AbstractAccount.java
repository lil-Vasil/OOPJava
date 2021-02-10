package po81.kartashova.oop.model.account;

import po81.kartashova.oop.model.Person;
import po81.kartashova.oop.model.tariff.Tariff;

public abstract class AbstractAccount implements Account {
    private long accountNumber;
    private Tariff tariff;
    private Person person;

    protected AbstractAccount(long accountNumber, Tariff tariff) {
        this.accountNumber = accountNumber;
        this.tariff = tariff;
    }

    public AbstractAccount() {
    }

    public long getNumber() {
        return accountNumber;
    }

    public Tariff getTariff () {
        return  tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Person getPerson() {
        return person;
    }
}
