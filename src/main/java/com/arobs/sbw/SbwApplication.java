package com.arobs.sbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = {"com.arobs"})
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.arobs.sbw.repositories")
public class SbwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwApplication.class, args);
    }

}
