package com.example.aliarslan.basickafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BasicKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicKafkaDemoApplication.class, args);
	}
}
