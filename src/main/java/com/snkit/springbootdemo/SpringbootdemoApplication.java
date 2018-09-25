package com.snkit.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringbootdemoApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println("    From Command line runner  ::::::::::::::::::::::::   ");
		
		System.out.println("    From Command line runner  ::::::::::::::::::::::::   ");
		
		userRepository.findAll().forEach(user -> {
			System.out.println("    User    "+user.toString());
		});
		
	}
	
	
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
