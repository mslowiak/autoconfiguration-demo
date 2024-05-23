package com.github.mslowiak.autoconfigurationdemoapplication;

import error.api.BusinessException;
import error.configuration.ErrorHandlerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AutoConfigurationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationDemoApplication.class, args);
    }

    @Bean
    ErrorHandlerConfiguration errorHandlerConfiguration() {
        return new ErrorHandlerConfiguration("X-Problem-Category", 422);
    }

    @RestController
    static class SampleController {
        @GetMapping("/demo")
        ResponseEntity<String> demo() {
            throw new BusinessException("MY_ERROR", "This is a business exception!");
        }
    }

}
