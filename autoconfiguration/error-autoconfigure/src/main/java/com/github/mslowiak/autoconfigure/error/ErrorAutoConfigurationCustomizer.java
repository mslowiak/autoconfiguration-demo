package com.github.mslowiak.autoconfigure.error;

import error.configuration.ErrorHandlerConfiguration;

public interface ErrorAutoConfigurationCustomizer {

    void customize(ErrorHandlerConfiguration configuration);

}
