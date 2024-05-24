package com.funtikov.web.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ScheduleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/settings").setViewName("work");
		registry.addViewController("/help").setViewName("work");
		registry.addViewController("/logout").setViewName("logout");
		registry.addViewController("/error").setViewName("error");
	}
}
