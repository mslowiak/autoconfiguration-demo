package com.github.mslowiak.autoconfigurationdemoapplication;

import error.api.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AutoConfigurationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationDemoApplication.class, args);
    }

    @RestController
    static class SampleController {
        @GetMapping("/demo")
        ResponseEntity<String> demo() {
            throw new BusinessException("MY_ERROR", "This is a business exception!");
        }
    }

}
