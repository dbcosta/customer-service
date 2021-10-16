package com.demo.app.customerservice.controller;


import com.demo.app.customerservice.resource.CustomerResource;
import com.demo.app.customerservice.resource.ErrorResource;
import com.demo.app.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerResource customerResource){
        try {
            Optional<CustomerResource> createdCustomer = customerService.createCustomer(customerResource);
            if(createdCustomer.isPresent()){
                return new ResponseEntity<>(createdCustomer.get(), HttpStatus.CREATED);
            }else{
                log.error("Customer not created. An Error occurred.");
                throw new Exception("Customer not created. An Error occurred.");
            }
        } catch (Exception exception) {
            ErrorResource errorResource = new ErrorResource();
            errorResource.setErrorMessage("An error occurred with your request.");
            errorResource.setErrorSource("Error while trying to create a new customer.");
            errorResource.setErrorReason("Error occurred on the server side. Please try again after some time.");
            log.error("Customer service Error Details: {} Customer mobile number: {}",exception,customerResource.getMobileNumber());
            return new ResponseEntity<>(errorResource,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{mobile-number}")
    public ResponseEntity<?> getCustomerByMobileNumber(@PathVariable("mobile-number") String mobileNumber){
        try {
            Optional<CustomerResource> foundCustomer = customerService.getCustomerByMobileNumber(mobileNumber);
            if(foundCustomer.isPresent()){
                return new ResponseEntity<>(foundCustomer,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            ErrorResource errorResource = new ErrorResource();
            errorResource.setErrorMessage("An error occurred with your request.");
            errorResource.setErrorSource("Error while trying to retrieve a customer by the mobile number.");
            errorResource.setErrorReason("Error occurred on the server side. Please try again after some time.");
            log.error("Customer service Error Details: {} Customer mobile number: {}",exception,mobileNumber);
            return new ResponseEntity<>(errorResource,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
