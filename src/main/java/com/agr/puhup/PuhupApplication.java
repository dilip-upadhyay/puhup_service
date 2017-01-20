package com.agr.puhup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PuhupApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PuhupApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<PuhupApplication> applicationClass = PuhupApplication.class;
}
