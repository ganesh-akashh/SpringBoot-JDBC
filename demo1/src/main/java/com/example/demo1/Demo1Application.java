package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo1.model.Alien;
import com.example.demo1.repo.AlienRepo;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo1Application.class, args);

		Alien alien1=context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Akash");
		alien1.setTech("Java");
        

		AlienRepo repo=context.getBean(AlienRepo.class);
		repo.save(alien1);

		 System.out.println(repo.findAll());
		

	}

}
