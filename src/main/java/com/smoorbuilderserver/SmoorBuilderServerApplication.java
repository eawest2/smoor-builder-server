package com.smoorbuilderserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.smoorbuilderserver.utils.seeders.Seeder;

@SpringBootApplication
public class SmoorBuilderServerApplication {
	
	@Autowired
	private Seeder seeder;
	
	public static void main(String[] args) {
		SpringApplication.run(SmoorBuilderServerApplication.class, args);
	}
	
//	Seeder seeder = new Seeder();
	
	@EventListener (ApplicationReadyEvent.class)
	public void	runSeeder(ApplicationReadyEvent event) {
		seeder.runSeeder(event);
	}
}
