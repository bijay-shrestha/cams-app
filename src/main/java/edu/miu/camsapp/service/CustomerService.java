package edu.miu.camsapp.service;

import edu.miu.camsapp.model.Customer;

import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
public interface CustomerService {
    Collection<Customer> saveAllCustomers(List<Customer> customers);
    Customer saveCustomer(Customer customer);
}
