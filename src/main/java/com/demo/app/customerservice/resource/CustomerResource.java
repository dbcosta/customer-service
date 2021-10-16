package com.demo.app.customerservice.resource;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name="Customer")
@Table(name = "Customer")
public class CustomerResource {

    @Id
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id")
    private String emailId;
}
