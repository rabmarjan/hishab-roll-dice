package com.hisab.game.dice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * It configures the Feign client to log all requests and responses
 */
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
