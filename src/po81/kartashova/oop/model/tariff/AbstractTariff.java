package po81.kartashova.oop.model.tariff;

import po81.kartashova.oop.model.Service;

public abstract class AbstractTariff implements Tariff {

    @Override
    public Service[] servicesSortArray() {
        Service[] services = serviceNotNullArray(); //почему подчеркивает
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < services.length - 1; i++) {
                if (services[i].getPrice() > services[i + 1].getPrice()) {
                    Service tmp = services[i + 1];
                    services[i + 1] = services[i];
                    services[i] = tmp;
                    isSorted = false;
                }
            }
        }
        return services;
    }
}
