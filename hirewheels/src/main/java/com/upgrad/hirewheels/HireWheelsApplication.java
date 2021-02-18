package com.upgrad.hirewheels;

import dao.UsersDao;
import entities.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import services.InitServiceImp;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireWheelsApplication.class, args);


		InitServiceImp test=new InitServiceImp();
		test.start();
		Users user1=new Users(1,"pavan","kumar");
		Users user2=new Users(1,"rajnesh","kumar");
		System.out.println("this is m project");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
