package po81.kartashova.oop.model;

public class Test {
    public static void main(String[] args) {

        Service internet = new Service("internet", 300);
        Service sms = new Service("sms", 150);
        Service calls = new Service("calls", 200);

        IndividualsTariff megafonPlus = new IndividualsTariff();
        megafonPlus.addService(internet);
        megafonPlus.addService(sms);
        megafonPlus.addService(calls);

        megafonPlus.addServicesByNumber(2, internet);

    }
}
