package com.lokesh.webclientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Building REST client Application
 * @Author Lokesh Singh
 */
@SpringBootApplication
public class WebclientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientDemoApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(AnimalService animalService){
//		return args -> {
//			animalService.getAnimals()
//					.subscribe(System.out::println);
//		};
//	}
}
