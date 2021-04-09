package com.epe.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epe.jpa.test.ORDERtest;

@SpringBootApplication
public class HelloJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml 에서 설정한 name값
		//emf 는 하나만 생성한다. 프로젝트 당 하나 
		
//		CRUDtest.test(emf);
//		JPQLtest.test(emf);

		ORDERtest.test(emf);
		
	}

}
