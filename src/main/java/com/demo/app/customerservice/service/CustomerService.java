package com.demo.app.customerservice.service;

import com.demo.app.customerservice.resource.CustomerResource;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerResource> createCustomer(CustomerResource customer);

    Optional<CustomerResource> getCustomerByMobileNumber(String mobileNumber);
}
