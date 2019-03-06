package com.softvision.ecommerce.products.cofig.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.softvision")
@EnableSwagger2
public class Products {

	public static void main(String[] args) {
		SpringApplication.run(Products.class, args);
	}
}
