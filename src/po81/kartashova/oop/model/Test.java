package po81.kartashova.oop.model;

public class Test {
    public static void main(String[] args) {

        Service internet = new Service("internet", 300);
        Service sms = new Service("sms", 150);
        Service calls = new Service("calls", 200);
        Service music = new Service("music", 350);
        Service games = new Service("games", 350);
        Person vlad = new Person("Vlad", "Gorbunov");
        Person vasilina = new Person("Vasilina", "Kartashova");
        Person zina = new Person("Zina", "Grebenkina");

        IndividualsTariff mtsPlus = new IndividualsTariff();
        IndividualsTariff megafonPlus = new IndividualsTariff();
        Account accountVlad = new Account(1, vlad, megafonPlus);
        Account accountVasilina = new Account(2, vasilina, megafonPlus);
        Account accountZina = new Account(3, zina, mtsPlus);

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
    }

    public static void lab2tests() {
    }
}
