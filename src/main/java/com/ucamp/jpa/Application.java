package com.ucamp.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// private 필드를 찾아올 수 있게 해줌
//		modelMapper.getConfiguration()
//				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
//				.setFieldMatchingEnabled(true);
		return modelMapper;
	}
}
