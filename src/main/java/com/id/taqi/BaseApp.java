package com.id.taqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@Configuration
@ComponentScan(value = {"com.id.taqi"})
public class BaseApp {

	public static void main(String[] args) {
		SpringApplication.run(BaseApp.class, args);
	}

}
