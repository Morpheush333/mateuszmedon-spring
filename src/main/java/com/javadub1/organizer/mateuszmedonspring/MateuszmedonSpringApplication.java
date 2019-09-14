package com.javadub1.organizer.mateuszmedonspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MateuszmedonSpringApplication {

	@Autowired
	private HelloBean helloBean;

	public static void main(String[] args) {
		SpringApplication.run(MateuszmedonSpringApplication.class, args);

	}

	@PostConstruct
	public void run() {
		helloBean.hello();
	}

}
