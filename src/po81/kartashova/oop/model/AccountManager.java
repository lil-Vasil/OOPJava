package po81.kartashova.oop.model;

import po81.kartashova.oop.model.account.Account;
import po81.kartashova.oop.model.account.IndividualAccount;
import po81.kartashova.oop.model.tariff.Tariff;

import java.util.Arrays;

public class AccountManager {

    private final Account[] accounts;
    private int count = 0;

    public AccountManager(int size) {
        this.accounts = new Account[size];
    }

    public AccountManager(Account[] accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (isNullAccount(i)) {
                accounts[i] = account;
                count++;
                break;
            }
        }
        return true;
    }

    public boolean addAccountByNumber(int index, Account account) {
        if (isNullAccount(index)) {
            accounts[index] = account;
            count++;
            return true;
        }
        return false;
    }

    private boolean isNullAccount(int index) {
        return accounts[index] == null;
    }

    public Account getAccount(int index) {
        return accounts[index];
    }

    public Account setAccount(int index, IndividualAccount account) {
        Account oldAccount = accounts[index];
        accounts[index] = account;
        return oldAccount;
    }

    public Account removeAccount(int index) {
        Account oldAccount = accounts[index];
        for (int i = 0; i < accounts.length; i++) {
            if (i == index) {
                accounts[index] = null;
                count--;
                break;
            }
        }
        for (int j = index; j < accounts.length - 1; index++) {
            accounts[j] = accounts[j + 1];
        }
        accounts[accounts.length - 1] = null;
        return oldAccount;
    }

    public int getCountOfAccounts() {
        return count;
    }

    public Account[] getAccountsArray() {
        return accounts;
    }

    public Tariff getTariff(int accountNumber) {
        for (Account account : accounts) {
            if (account != null & isNumberAccount(account, accountNumber)) {
                return account.getTariff();
            }
        }
        return null;
    }

    public Tariff setTariff(int accountNumber, Tariff tariff) {
        Tariff oldTariff = null;
        for (Account account : accounts) {
            if ((account != null) && isNumberAccount(account, accountNumber)) {
                oldTariff = account.getTariff();
                account.setTariff(tariff);
            }
        }
        return oldTariff;
    }


    private boolean isNumberAccount(Account account, int number) {
        return account.getNumber() == number;
    }


    public Account[] getAccountsByServiceType(ServiceTypes serviceTypes) {
        Account[] notNullAccountArray = accountsNotNullArray();
        return (Account[]) Arrays.stream(notNullAccountArray)
                .filter(account -> getServiceArraySizeByType(account.getTariff(), serviceTypes) > 0)
                .toArray();
//        Account[] accountArrayByServiceType = new Account[count];
//        int count = 0;
//        for (int i = 0; i <= notNullAccountArray.length; i++) {
//            Service[] servicesByType = getServiceArrayByType(notNullAccountArray[i].getTariff(), serviceTypes);
//            if (servicesByType.length != 0) {
//                accountArrayByServiceType[count] = notNullAccountArray[i];
//                count++;
//            }
//        }
//        return accountArrayByServiceType;
    }

    private int getServiceArraySizeByType(Tariff tariff, ServiceTypes serviceTypes) {
        return tariff.serviceTypesArray(serviceTypes).length;
    }

    public Account[] accountsNotNullArray() {
        Account[] newArray = new Account[count];
        int count = 0;
        for (Account account : accounts) {
            if (account != null) {
                newArray[count] = account;
                count++;
            }

        }
        return newArray;
    }

    public Long[] getIndividualNumbers() {
        return (Long[]) Arrays.stream(accounts).map(Account::getNumber).toArray();
    }

    public Long[] getEntityNumbers() {
        return (Long[]) Arrays.stream(accounts).map(Account::getNumber).toArray();
    }


}