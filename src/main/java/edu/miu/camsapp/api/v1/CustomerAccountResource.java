package edu.miu.camsapp.api.v1;

import edu.miu.camsapp.model.Account;
import edu.miu.camsapp.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static edu.miu.camsapp.constant.ResourceKeyConstant.CUSTOMER_ACCOUNTS;
import static edu.miu.camsapp.constant.ResourceKeyConstant.CustomerAccountMVCResource.CUSTOMER_ACCOUNT_RESOURCE;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Controller
@RequestMapping(value = CUSTOMER_ACCOUNT_RESOURCE)
public class CustomerAccountResource {

    private final AccountService accountService;

    public CustomerAccountResource(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = CUSTOMER_ACCOUNTS)
    public ModelAndView listSuppliers() {
        var customerAccounts = accountService
                .getCustomerAccountsDescendingByBalance();
        return getModelAndView(customerAccounts);
    }

    private ModelAndView getModelAndView(Collection<Account> customerAccounts) {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", customerAccounts);
        modelAndView.addObject("liquidityPosition",
                getLiquidityPosition(customerAccounts));
        modelAndView.addObject("size", customerAccounts.size());
        modelAndView.setViewName("secured/account/list");
        return modelAndView;
    }

    private double getLiquidityPosition(Collection<Account> customerAccounts) {
        double liquidityPosition = 0.0;
        for(Account account: customerAccounts){
            liquidityPosition+=account.getBalance();
        }
        return liquidityPosition;
    }
}
