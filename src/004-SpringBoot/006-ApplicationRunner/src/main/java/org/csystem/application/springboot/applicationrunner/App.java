package org.csystem.application.springboot.applicationrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.csystem.springboot", "org.csystem.application.springboot"})
@ComponentScan(basePackages = "org.csystem")
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
