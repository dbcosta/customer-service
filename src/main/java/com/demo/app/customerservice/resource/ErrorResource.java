package com.demo.app.customerservice.resource;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ErrorResource {
    private String errorSource;
    private String errorMessage;
    private String errorReason;
}
