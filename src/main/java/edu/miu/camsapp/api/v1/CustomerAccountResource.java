package edu.miu.camsapp.api.v1;

import edu.miu.camsapp.model.Account;
import edu.miu.camsapp.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Controller
@RequestMapping(value = "/spebank/account")
public class CustomerAccountResource {

    private final AccountService accountService;

    public CustomerAccountResource(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = "/list")
    public ModelAndView listSuppliers() {
        var customerAccounts = accountService.getCustomerAccountsDescendingByBalance();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", customerAccounts);
        double liquidityPosition = 0.0;
        for(Account account: customerAccounts){
            liquidityPosition+=account.getBalance();
        }
        modelAndView.addObject("liquidityPosition", liquidityPosition);
        modelAndView.addObject("size", customerAccounts.size());
        modelAndView.setViewName("secured/account/list");
        return modelAndView;
    }
}
