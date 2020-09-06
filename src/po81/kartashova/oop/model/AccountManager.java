package po81.kartashova.oop.model;

public class AccountManager {

    private Account[] accounts;
    private int size = 0;

    public AccountManager(int size) {
        this.size = size;
    }

    public AccountManager(Account[] accounts) {
        this.accounts = accounts;
        Account[] newAccounts = new Account[size]; //в конструкторе происходит копирование элементов в новый массив, и ссылка на него записывается в атрибут (?)
        for (int i = 0; i < accounts.length ; i++) {
            accounts[i] = newAccounts[i];
        }
    }

    public boolean addAccount(Account account) {

        for (int i = 0; i < size; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                size ++;
                break;
            }
        }
        return true;
    }

    public boolean addAccountByNumber(int index, Account account) {
        for (int i = 0; i < size ; i++) {
            accounts[index] = account;

        }
        return true;
    }

    public Account getAccount(int index) {
        return accounts[index];
    }

    public Account setAccount(int index, Account account) {
        Account oldAccount = accounts[index];
        accounts[index] = account;
        return oldAccount;
    }

    public Account removeAccount(int index) {
        Account oldAccount = accounts[index];
        for (int i = 0; i < size ; i++) {
            if (accounts.equals(index)){
                    accounts[index] = null;
                }
            }
        for (int j = index; j < size - 1; index++) {
            accounts[j] = accounts [j + 1];
        }
        accounts[size -1] = null;
        size --;
        return oldAccount;
    }

    public int getCountOfAccounts() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null) {
                count++;
            }

        }
        return count;
    }

    public Account[] getAccountsArray() {
        return accounts;
    }

    public IndividualsTariff getTariff(int accountNumber) {
        for (int i = 0; i < size; i++) {
            if ((accounts[i] != null) & (accounts[i].getNumber() == accountNumber)) {
                accounts[i].getTariff(); //объясни Манульчику, каким образом у нас работает метод getTariff
            }

        }
        return null;

    }

    public IndividualsTariff setTariff(int accountNumber, IndividualsTariff tariff) {
        IndividualsTariff oldTariff = null;
        for (int i = 0; i < size; i++) {
            if ((accounts[i] != null) & (accounts[i].getNumber() == accountNumber)) {
                oldTariff = accounts[i].getTariff();
                accounts[i].setTariff(tariff);

            }

        }
        return oldTariff;
    }



}

