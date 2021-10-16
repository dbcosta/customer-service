package com.demo.app.customerservice.service.impl;

import com.demo.app.customerservice.repository.CustomerRepository;
import com.demo.app.customerservice.resource.CustomerResource;
import com.demo.app.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<CustomerResource> createCustomer(CustomerResource customerResource) {
        CustomerResource savedCustomer = customerRepository.save(customerResource);
        if(savedCustomer!=null){
            return Optional.of(savedCustomer);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResource> getCustomerByMobileNumber(String mobileNumber) {
        return customerRepository.findById(mobileNumber);
    }
}
