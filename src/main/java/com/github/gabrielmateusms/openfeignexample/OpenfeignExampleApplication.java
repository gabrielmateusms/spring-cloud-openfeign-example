package com.github.gabrielmateusms.openfeignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignExampleApplication.class, args);
	}

}
