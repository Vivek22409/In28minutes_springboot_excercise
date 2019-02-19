package com.vivek.BHB_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vivek.controller"} )
public class BhbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhbAppApplication.class, args);
	}

}

