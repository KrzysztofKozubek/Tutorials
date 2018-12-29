package impl;

import domain.Account;

import java.util.logging.Logger;

public class AccountCreator {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Account createAccount(String name) {
        logger.info("Creating account:" + name);
        Account account = new Account();
        account.setName(name);
        return account;
    }
}
