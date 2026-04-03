package com.financeapp;

import com.financeapp.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(CategoryService categoryService) {
		return args -> {
			categoryService.initializeDefaultCategories();
		};
	}
}
