package com.hisab.game.dice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * The `@Configuration` annotation tells Spring that this class is a configuration class. The `@Value` annotation tells
 * Spring to inject the value of the property into the field
 */
@Configuration
@Getter
public class ServiceConfiguration {
    @Value("${service.properties.short-code:STR}")
    private String shortCode;

    @Value("${service.properties.version:v0.1}")
    private String version;


}
