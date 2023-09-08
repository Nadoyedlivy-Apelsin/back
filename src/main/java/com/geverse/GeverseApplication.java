package com.geverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.geverse"})
@EnableJpaRepositories(basePackages = {"com.geverse.repository"})
public class GeverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeverseApplication.class, args);
    }

}
