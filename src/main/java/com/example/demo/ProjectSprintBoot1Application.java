package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;


import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class ProjectSprintBoot1Application {

	private static final Logger log = LoggerFactory.getLogger(ProjectSprintBoot1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectSprintBoot1Application.class);
	}
	
	/*
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			UserRepository repository = new CrudRepository();
			// save a couple of users
			Role user = new Role("USER");
			Role admin = new Role("ADMIN");
			
			Set<Role> roleUser = new HashSet<Role>();
			roleUser.add(user);
			
			Set<Role> roleAdmin = new HashSet<Role>();
			roleAdmin.add(user);
			roleAdmin.add(admin);
			
			repository.save(new User("user@test.fr", "user"));
			repository.save(new User("admin@test.fr", "admin"));

			// fetch all users
			log.info("users found with findAll():");
			log.info("-------------------------------");
			for (User usr : repository.findAll()) {
				log.info(usr.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(usr -> {
					log.info("User found with findById(1L):");
					log.info("--------------------------------");
					log.info(usr.toString());
					log.info("");
				});

			// fetch users by username
			/*
			log.info("Customer found with findByUsername('user@test.fr'):");
			log.info("--------------------------------------------");
			repository.findByUsername("user@test.fr").forEach(usr -> {
				log.info(usr.toString());
			});*/
			// for (User usr: repository.findByUsername("user@test.fr")) {
			// 	log.info(usr.toString());
			// }
	/*
			log.info("");
		};
	}*/


}

