package com.web.hzxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.hzxy.dao")
public class HzxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HzxyApplication.class, args);
	}
}
