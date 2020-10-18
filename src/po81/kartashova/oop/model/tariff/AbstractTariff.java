package po81.kartashova.oop.model.tariff;

import po81.kartashova.oop.model.Service;
import po81.kartashova.oop.model.ServiceTypes;

public abstract class AbstractTariff implements Tariff {

    @Override
    public Service[] servicesSortArray() {
        Service[] services = serviceNotNullArray();
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

    @Override
    public Service[] serviceTypesArray(ServiceTypes type) {
        Service[] services = serviceNotNullArray();
        Service[] servicesSpecifiedType = new Service[getCountOfServices()];
        int count = 0;
        for (int i = 0; i < services.length; i++) {
            if (services[i].getServiceTypes().equals(type)) {
                servicesSpecifiedType[count] = services[i];
                count++;
            }
        }
        return serviceTypesNotNullArray(servicesSpecifiedType);

    }

    public static Service[] serviceTypesNotNullArray(Service[] servicesSpecifiedType) {
        Service[] newArray = new Service[servicesSpecifiedType.length];
        int count = 0;
        for (Service service : servicesSpecifiedType) {
            if (service != null) {
                newArray[count] = service;
                count++;
            }
        }
        return null;
    }
}
