package com.zjm;

import com.zjm.service.StorageService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@MapperScan(basePackages = "com.zjm.dao")
@SpringBootApplication
public class IshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(IshopApplication.class, args);
	}

}
