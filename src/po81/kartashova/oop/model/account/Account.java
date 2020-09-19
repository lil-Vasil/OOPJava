package po81.kartashova.oop.model.account;

import po81.kartashova.oop.model.tariff.Tariff;

public interface Account {

    int getNumber();

    Tariff getTariff();

    void setTariff(Tariff tariff);
}
