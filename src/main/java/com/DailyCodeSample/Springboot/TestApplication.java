package com.DailyCodeSample.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TestApplication.class, args);

		Date date = new Date();

		Timestamp time = new Timestamp(date.getTime());

		Timestamp time1 =new Timestamp(System.currentTimeMillis());

		System.out.println("Hello Correct time is .......");

		System.out.println(time);

		System.out.println("Hello Correct time is .......");

		System.out.println(time1);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
