package po81.kartashova.oop.model.tariff;

import po81.kartashova.oop.model.Service;

public interface Tariff {

    boolean addService(Service service);

    boolean addServicesByNumber(int index, Service service);

    Service getService(int countOfService);

    Service getLinkByName(String name);

     boolean getServiceByName(String name);

     Service changeLinkByIndex(int index, Service service);

     Service deleteServiceByIndex(int index);

     Service deleteServiceByName(String name);

     int getCountOfServices();

     Service[] serviceNotNullArray();

     Service[] servicesSortArray();

     int getPrice();


}
