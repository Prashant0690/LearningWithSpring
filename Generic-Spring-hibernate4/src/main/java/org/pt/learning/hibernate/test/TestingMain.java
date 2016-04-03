package org.pt.learning.hibernate.test;

import java.util.Date;

import org.pt.learn.hibernate.daoJpaImpl.UserDaoImpl;
import org.pt.learn.hibernate.entity.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public abstract class TestingMain {

	public static void main(String[] args) {
		Users users = new Users();
		
		users.setUserName("sachin100");
		users.setEmail("sachin.R.T@gmail.com");
		users.setMessage("NEW USER");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/hibernatePersistenceConfig.xml");
		UserDaoImpl userDaoImpl = context.getBean("userDao",UserDaoImpl.class);
		userDaoImpl.create(users);
		System.out.println(userDaoImpl.findAll());

	}

}
