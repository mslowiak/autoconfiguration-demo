package com.github.mslowiak.autoconfigure.error;

import error.configuration.ErrorHandlerConfiguration;
import error.handler.BusinessExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnBean(ErrorHandlerConfiguration.class)
public class ErrorAutoConfiguration {

    @Bean
    public BusinessExceptionHandler businessExceptionHandler(ErrorHandlerConfiguration errorHandlerConfiguration) {
        return new BusinessExceptionHandler(errorHandlerConfiguration) {
        };
    }

}
