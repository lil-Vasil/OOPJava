package po81.kartashova.oop.model;

import po81.kartashova.oop.model.account.Account;
import po81.kartashova.oop.model.account.IndividualAccount;
import po81.kartashova.oop.model.tariff.EntityTariff;
import po81.kartashova.oop.model.tariff.Tariff;

public class Test {
    public static void main(String[] args) {
        Service service1 = new Service(ServiceTypes.INTERNET, "service1", 50);
        Service service2 = new Service(ServiceTypes.MAIL, "service2", 100);
        Service service3 = new Service(ServiceTypes.PHONE, "service3", 150);
        Service service4 = new Service(ServiceTypes.STORAGE, "service4", 50);
        Service service5 = new Service(ServiceTypes.ADDITIONAL_SERVICE, "service5", 200);
        Service service6 = new Service(ServiceTypes.INTERNET, "service6", 300);
        Service service7 = new Service(ServiceTypes.PHONE, "service7", 250);
        Service service8 = new Service(ServiceTypes.MAIL, "service8", 350);
        Service[] services = new Service[8];
        Tariff testTariff = new EntityTariff();
        testTariff.addService(service1);
        testTariff.addService(service2);
        testTariff.addService(service3);
        testTariff.addService(service4);
        testTariff.addService(service5);
        testTariff.addService(service6);
        testTariff.addService(service7);
        testTariff.addService(service8);
        Service service = testTariff.getService(7);
        Service deleteService = testTariff.deleteServiceByIndex(2);
        testTariff.addServicesByNumber(2, service5);
        Service changeService = testTariff.changeLinkByIndex(5, service1);
        Service linkService = testTariff.getLinkByName("service1");
        Service deleteServiceByName = testTariff.deleteServiceByName("service7");
        int count = testTariff.getCountOfServices();
        Service[] notNull = testTariff.serviceNotNullArray();
        int price = testTariff.getPrice();

        Person vlad = new Person("Vlad", "Gorbunov");
        Person vasilina = new Person("Vasilina", "Kartashova");
        Person zina = new Person("Zina", "Grebenkina");
        Account IndividualAccount1 = new IndividualAccount(1, vlad);
        Account IndividualAccount2 = new IndividualAccount(2, vasilina);
        Account IndividualAccount3 = new IndividualAccount(3, zina);
        long number = IndividualAccount2.getNumber();
        Tariff tariff = IndividualAccount3.getTariff();

        Person entityPerson1 = new Person("Vlad", "Gorbunov");
        Person entityPerson2 = new Person("Vasilina", "Kartashova");
        Person entityPerson3 = new Person("Zina", "Grebenkina");
    }

       /* Service internet = new Service("internet", 300);
        Service sms = new Service("sms", 150);
        Service calls = new Service("calls", 200);
        Service music = new Service("music", 350);
        Service games = new Service("games", 350);
        Person vlad = new Person("Vlad", "Gorbunov");
        Person vasilina = new Person("Vasilina", "Kartashova");
        Person zina = new Person("Zina", "Grebenkina");

        IndividualsTariff mtsPlus = new IndividualsTariff();
        IndividualsTariff megafonPlus = new IndividualsTariff();
        IndividualAccount accountVlad = new IndividualAccount(1, vlad, megafonPlus);
        IndividualAccount accountVasilina = new IndividualAccount(2, vasilina, megafonPlus);
        IndividualAccount accountZina = new IndividualAccount(3, zina, mtsPlus);

        AccountManager myAccount = new AccountManager(8);
        myAccount.addAccount(accountVlad);
        myAccount.addAccount(accountVlad);
        myAccount.addAccount(accountVlad);
        myAccount.addAccount(accountVasilina);
        myAccount.addAccount(accountZina);
        myAccount.addAccount(accountZina);
        myAccount.addAccount(accountZina);
        myAccount.addAccount(accountZina);
        Account[] accounts = myAccount.getAccountsArray();
        myAccount.addAccountByNumber(2, accountVasilina);
        myAccount.getAccount(3);
        myAccount.setAccount(4, accountVasilina);
        myAccount.removeAccount(7);
        Tariff myTariff = myAccount.getTariff(1);
        Tariff tariff = myAccount.setTariff(3, mtsPlus);
        int count = myAccount.getCountOfAccounts();

        megafonPlus.addService(internet);
        megafonPlus.addService(sms);
        megafonPlus.addService(calls);

        megafonPlus.addServicesByNumber(2, internet);
        megafonPlus.getLinkByName("sms");
        megafonPlus.addServicesByNumber(4, music);
        megafonPlus.addServicesByNumber(3, games);
        megafonPlus.deleteServiceByIndex(2);
        megafonPlus.getServiceByName("games");
        megafonPlus.changeLinkByIndex(3, sms);
        int countOfServices = megafonPlus.getCountOfServices();
        Service[] myServices = megafonPlus.servicesSortArray();


         public static void lab2tests() {


    }*/


}
