package com.qa.person;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class StarterCarApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StarterCarApplication.class, args);
		ApplicationContext context = SpringApplication.run(StarterCarApplication.class, args);
		
//		Object byName = context.getBean("time");
//		LocalTime byType = context.getBean(LocalTime.class);
//		LocalTime byBoth = context.getBean("time", LocalTime.class);
//
//		System.out.println(byName);
//		System.out.println(byType);
//		System.out.println(byBoth);
//		
//		Object byNames = context.getBean("greeting");
//		String byTypes = context.getBean("greeting", String.class);
//		String byBoths = context.getBean("greeting", String.class);
//
//		System.out.println(byNames);
//		System.out.println(byTypes);
//		System.out.println(byBoths);
//		
//		
//		Object byName1 = context.getBean("farewell");
//		String byType1 = context.getBean("farewell", String.class);
//		String byBoth1 = context.getBean("farewell", String.class);
//
//		System.out.println(byName1);
//		System.out.println(byType1);
//		System.out.println(byBoth1);
	}

	

}
