package po81.kartashova.oop.model;

import java.util.Arrays;

public class IndividualsTariff {

    public static final int DEFAULT_SIZE = 8;
    public static final int MAX_PRICE = 50;

    private Service[] services;
    int countOfServices = 0; //кол-во добавленных услуг

    public IndividualsTariff() {
        this.services = new Service[DEFAULT_SIZE];
    }

    public IndividualsTariff(int size) {
        this.services = new Service[size];
    }

    public IndividualsTariff(Service[] services) {
        this.services = services;
    }

    public boolean addService(Service service) {
        if (countOfServices <= DEFAULT_SIZE) {
            services[countOfServices] = service;
            countOfServices++;
        } else {
            Service[] services1 = Arrays.copyOf(services, services.length * 2);
        }
        return true;
    }

    public boolean addServicesByNumber(int index, Service service) {
        services[index] = service;
        return true;
    }

    public Service getService(int countOfServices) {
        return services[countOfServices];
    }

    public Service getLinkByName(String name) {
        for (int i = 0; i <= DEFAULT_SIZE; i++) {
            if (services[i].getName().equals(name)) {
                return services[i];
            }
        }
        return null;
    }

    public boolean getServiceByName(String name) {
        for (int i = 0; i <= DEFAULT_SIZE; i++) {
            if (services[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Service changeLinkByIndex(int index, Service service) {
        Service oldService = services[index];
        services[index] = service;

        return oldService;
    }


    public Service deleteServiceByIndex(int index) {
        Service oldService = services[index];
        int i = 0;
        for (; i <= countOfServices; i++) {
            if (i == index) {
                services[i] = null;
                break;
            }
        }
        for (int j = i; i < countOfServices - 1; i++) {
            services[j] = services[j + 1];
        }
        services[countOfServices - 1] = null;
        --countOfServices;
        return oldService;
    }

    public int getCountOfServices() {
        return countOfServices;
    }

    public Service[] serviceNotNullArray() {
        Service[] newArray = new Service[countOfServices];
        countOfServices = 0;
        for (Service service : services) {
            if (service != null) {
                newArray[countOfServices] = service;
            }
            countOfServices++;

        }
        return newArray;
    }

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

    public int getPrice() {
        int price = 0;
        Service[] services = serviceNotNullArray();
        for (int i = 0; i < services.length ; i++) {
                price += services[i].getPrice();
        }
        return price + MAX_PRICE;
    }
}




