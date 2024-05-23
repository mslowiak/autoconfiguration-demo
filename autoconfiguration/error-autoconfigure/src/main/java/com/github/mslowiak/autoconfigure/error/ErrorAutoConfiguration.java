package com.github.mslowiak.autoconfigure.error;

import java.util.Optional;

import error.configuration.ErrorHandlerConfiguration;
import error.handler.BusinessExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(BusinessExceptionHandler.class)
public class ErrorAutoConfiguration {

    @Bean
    public BusinessExceptionHandler businessExceptionHandler(Optional<ErrorAutoConfigurationCustomizer> autoConfigurationCustomizer) {
        final var errorHandlerConfiguration = new ErrorHandlerConfiguration("X-Problem-Category", 422);

        autoConfigurationCustomizer.ifPresent(customizer -> customizer.customize(errorHandlerConfiguration));

        return new BusinessExceptionHandler(errorHandlerConfiguration) {
        };
    }

}
