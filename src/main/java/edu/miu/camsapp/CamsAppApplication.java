package edu.miu.camsapp;

import edu.miu.camsapp.model.Account;
import edu.miu.camsapp.model.Customer;
import edu.miu.camsapp.service.AccountService;
import edu.miu.camsapp.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

@SpringBootApplication
public class CamsAppApplication implements CommandLineRunner {

    private final CustomerService customerService;
    private final AccountService accountService;

    public CamsAppApplication(CustomerService customerService, AccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CamsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer bob = new Customer("Bob", "Jones");
        bob = customerService.saveCustomer(bob);
        Customer anna = new Customer("Anna", "Smith");
        anna = customerService.saveCustomer(anna);
        Customer carlos = new Customer("Carlos", "Jimenez");
        carlos = customerService.saveCustomer(carlos);

        Account ac1001 = new Account(
                "AC1001",
                "Savings",
                LocalDate.of(2021, 11, 15),
                125.95);
        ac1001 = accountService.saveAccount(ac1001);
        ac1001.setCustomer(bob);
        accountService.saveAccount(ac1001);
        Account ac1002 = new Account(
                "AC1002",
                "Checking",
                LocalDate.of(2022,7,10),
                10900.50);
        ac1002 = accountService.saveAccount(ac1002);
        ac1002.setCustomer(anna);
        accountService.saveAccount(ac1002);
        Account ac1003 = new Account(
                "AC1003",
                "Savings",
                LocalDate.of(2022, 7, 11),
                15000);
        ac1003 = accountService.saveAccount(ac1003);
        ac1003.setCustomer(carlos);
        accountService.saveAccount(ac1003);

        out.println("Bob Account ::::" + ac1001);
        out.println("Anna Account ::::" + ac1002);
        out.println("Carlos Account ::::" + ac1003);


    }
}
