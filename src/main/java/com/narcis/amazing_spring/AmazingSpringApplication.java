package com.narcis.amazing_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class AmazingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazingSpringApplication.class, args);
	}

}
class Coffee {
	private final String id;
	private String name;

	public Coffee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
