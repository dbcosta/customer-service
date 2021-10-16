package com.demo.app.customerservice.repository;

import com.demo.app.customerservice.resource.CustomerResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerResource,String> {
}
