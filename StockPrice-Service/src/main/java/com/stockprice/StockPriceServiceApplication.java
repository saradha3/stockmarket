package com.stockprice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class StockPriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
