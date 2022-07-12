package edu.miu.camsapp.api.v2;

import edu.miu.camsapp.model.Account;
import edu.miu.camsapp.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@RestController
@RequestMapping(value = {"spebank/api/account"})
public class CustomerRestController {

    private final AccountService accountService;

    public CustomerRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/list")
    private ResponseEntity<Collection<Account>> getCustomerAccounts(){
        return ResponseEntity.ok(accountService.getCustomerAccountsDescendingByBalance());
    }


    @GetMapping(value = "/prime/list")
    private ResponseEntity<Collection<Account>> getPrimeCustomerAccounts(){
        return ResponseEntity.ok(accountService.getPrimeCustomerAccounts());
    }
}
