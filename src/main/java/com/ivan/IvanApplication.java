package com.ivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value={"file:${IVAN_CONFIG}"})
public class IvanApplication {

	public static void main(String[] args) {
		SpringApplication.run(IvanApplication.class, args);
	}

}
