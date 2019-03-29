package services.impl;

import data.DataAccount;
import entities.Account;
import services.IAccount;

public class AccountImpl implements IAccount {

    private static DataAccount dataAccount = new DataAccount();

    public boolean createNewAccount(Account acc) {
        boolean isAdded = false;

        try {
            dataAccount.addAccount(acc);
            isAdded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAdded;
    }

    public Account login(String username, String password) {
        Account logAccount = null;
        try {
            Account account = dataAccount.login(username, password);
            if( account != null){
                logAccount = account;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return logAccount;

    }
}
