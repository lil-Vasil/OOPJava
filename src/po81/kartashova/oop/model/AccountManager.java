package po81.kartashova.oop.model;

public class AccountManager {

    private IndividualAccount[] accounts;
    private int count = 0;

    public AccountManager(int size) {
        this.accounts = new IndividualAccount[size];
    }

    public AccountManager(IndividualAccount[] accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(IndividualAccount account) {
        for (int i = 0; i < accounts.length; i++) {
            if (isNullAccount(i)) {
                accounts[i] = account;
                count++;
                break;
            }
        }
        return true;
    }

    public boolean addAccountByNumber(int index, IndividualAccount account) {
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

    public IndividualAccount getAccount(int index) {
        return accounts[index];
    }

    public IndividualAccount setAccount(int index, IndividualAccount account) {
        IndividualAccount oldAccount = accounts[index];
        accounts[index] = account;
        return oldAccount;
    }

    public IndividualAccount removeAccount(int index) {
        IndividualAccount oldAccount = accounts[index];
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

    public IndividualAccount[] getAccountsArray() {
        return accounts;
    }

    public Tariff getTariff(int accountNumber) {
        for (IndividualAccount account : accounts) {
            if (account != null & isNumberAccount(account, accountNumber)) {
                return account.getTariff();
            }
        }
        return null;
    }

    public Tariff setTariff(int accountNumber, Tariff tariff) {
        Tariff oldTariff = null;
        for (IndividualAccount account : accounts) {
            if ((account != null) && isNumberAccount(account, accountNumber)) {
                oldTariff = account.getTariff();
                account.setTariff(tariff);
            }
        }
        return oldTariff;
    }


    private boolean isNumberAccount(IndividualAccount account, int number) {
        return account.getNumber() == number;
    }
}

