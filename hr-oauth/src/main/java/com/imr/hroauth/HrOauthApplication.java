package com.imr.hroauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication implements CommandLineRunner {

	@Value("${jwt.secret}")
	private String JWT_SECRET;
	
	@Value("${oauth.client.secret}")
	private String CLIENT_SECRET;
	
	@Value("${oauth.client.username}")
	private String CLIENT_USERNAME;
	
	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(JWT_SECRET);
		System.out.println(CLIENT_SECRET);
		System.out.println(CLIENT_USERNAME);
	}

}
