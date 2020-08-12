package com.arobs.sbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(value = {"com.arobs"})
@EnableJpaAuditing
public class SbwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwApplication.class, args);
    }

}
