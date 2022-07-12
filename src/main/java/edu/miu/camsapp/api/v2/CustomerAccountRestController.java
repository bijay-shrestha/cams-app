package edu.miu.camsapp.api.v2;

import edu.miu.camsapp.model.Account;
import edu.miu.camsapp.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static edu.miu.camsapp.constant.ResourceKeyConstant.CUSTOMER_ACCOUNTS;
import static edu.miu.camsapp.constant.ResourceKeyConstant.CustomerAccountRestResource.*;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@RestController
@RequestMapping(value = CUSTOMER_ACCOUNT_REST_RESOURCE)
public class CustomerAccountRestController {

    private final AccountService accountService;

    public CustomerAccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = CUSTOMER_ACCOUNTS)
    private ResponseEntity<Collection<Account>> getCustomerAccounts(){
        return ResponseEntity.ok(accountService.getCustomerAccountsDescendingByBalance());
    }


    @GetMapping(value = PRIME_ACCOUNTS)
    private ResponseEntity<Collection<Account>> getPrimeCustomerAccounts(){
        return ResponseEntity.ok(accountService.getPrimeCustomerAccounts());
    }
}
