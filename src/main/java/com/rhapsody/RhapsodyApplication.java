package com.rhapsody;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.rhapsody.model"})
public class RhapsodyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhapsodyApplication.class, args);
	}

}
