package com.fetch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FetchproductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchproductServiceApplication.class, args);
	}

}
