package com.wildBirds.SystemTestsBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemTestsBackEndApplication {

	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
		SpringApplication.run(SystemTestsBackEndApplication.class, args);
	}
}
