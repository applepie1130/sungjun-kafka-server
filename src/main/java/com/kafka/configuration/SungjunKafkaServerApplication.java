package com.kafka.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.kafka.BasePackageLocation;

@SpringBootApplication
@ComponentScan(basePackageClasses = BasePackageLocation.class)
public class SungjunKafkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SungjunKafkaServerApplication.class, args);
	}

}
