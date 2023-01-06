package com.hisab.game.dice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * It's a Spring Boot application that uses Feign to call the Dice Service
 */
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Dice Rolling Game", version = "2.0", description = "Dice Game Information"))
public class DiceGameApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DiceGameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
