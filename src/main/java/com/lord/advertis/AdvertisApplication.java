package com.lord.advertis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lord.advertis.dao")
public class AdvertisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisApplication.class, args);
	}
}
