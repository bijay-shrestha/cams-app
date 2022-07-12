package edu.miu.camsapp.service;

import edu.miu.camsapp.model.Account;

import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
public interface AccountService {
    Collection<Account> saveAllAccounts(List<Account> accounts);

    Account saveAccount(Account account);
}
