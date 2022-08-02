package com.fuel.fueldistributionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.fuel.fueldistributionapp.model"})
@SpringBootApplication
public class FuelDistributionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelDistributionAppApplication.class, args);
	}

}
