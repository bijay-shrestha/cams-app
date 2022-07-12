package edu.miu.camsapp.service.impl;

import edu.miu.camsapp.repository.CustomerRepository;
import edu.miu.camsapp.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
