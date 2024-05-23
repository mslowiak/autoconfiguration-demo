package com.github.mslowiak.autoconfigurationdemoapplication;

import com.github.mslowiak.autoconfigure.error.ErrorAutoConfiguration;
import com.github.mslowiak.autoconfigure.error.ErrorAutoConfigurationCustomizer;
import error.api.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication//(exclude = ErrorAutoConfiguration.class)
public class AutoConfigurationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationDemoApplication.class, args);
    }

    @Bean
    public ErrorAutoConfigurationCustomizer errorAutoConfigurationCustomizer() {
        return configuration -> configuration.setHeaderName("X-ChatGpt-Header");
    }

    @RestController
    static class SampleController {
        @GetMapping("/demo")
        ResponseEntity<String> demo() {
            throw new BusinessException("MY_ERROR", "This is a business exception!");
        }
    }

}
