package com.dispatch.dispatchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"com.dispatch.controller","com.dispatch.service"})
@EnableJpaRepositories("com.dispatch.repository")
@EntityScan(basePackages = {"com.dispatch.entity"})
@SpringBootApplication
public class DispatchserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatchserviceApplication.class, args);
	}

}
