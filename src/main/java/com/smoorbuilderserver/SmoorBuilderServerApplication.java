package com.smoorbuilderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import com.smoorbuilderserver.utils.seeders.Seeder;

@SpringBootApplication
public class SmoorBuilderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoorBuilderServerApplication.class, args);
	}
	
	Seeder seeder = new Seeder();
	
	@EventListener (ContextRefreshedEvent.class)
	public void	runSeeder(ContextRefreshedEvent event) {
		System.out.println(">>>>>Seeder Start");
		seeder.runSeeder(event);
	}
}
