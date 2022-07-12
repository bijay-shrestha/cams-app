package edu.miu.camsapp.service.impl;

import edu.miu.camsapp.model.Customer;
import edu.miu.camsapp.repository.CustomerRepository;
import edu.miu.camsapp.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Collection<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
