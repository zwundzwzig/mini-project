package com.main.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"main","sale","user"})
@ComponentScan(basePackages = "novel")
//@Mapper 스캔 설정
@MapperScan(basePackages = "main,sale,user")

//1. 스프링부트 시작 클래스 - tomcat 시작
//@ComponentScan(basepackage="com.example.demo") 의 역할
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
