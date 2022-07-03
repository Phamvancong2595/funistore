package com.funistore.congpv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CongpvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongpvApplication.class, args);
	}

}
