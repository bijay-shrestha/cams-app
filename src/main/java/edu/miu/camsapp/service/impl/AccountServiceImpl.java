package edu.miu.camsapp.service.impl;

import edu.miu.camsapp.repository.AccountRepository;
import edu.miu.camsapp.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
