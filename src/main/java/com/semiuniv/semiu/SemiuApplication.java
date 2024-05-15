package com.semiuniv.semiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SemiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemiuApplication.class, args);
	}

}
