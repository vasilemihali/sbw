package com.arobs.sbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.arobs"})
public class SbwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbwApplication.class, args);
	}

}
