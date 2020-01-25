package com.robomq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.robomq.config.AppConfig;
import com.robomq.dao.MobileDAO;
import com.robomq.pojo.Mobile;




public class jdbcMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MobileDAO mobileDAO = context.getBean(MobileDAO.class);

		System.out.println("List of mobiles is:");

		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}
		
		System.out.println("\nCreating mobile: ");
		Mobile mobile = new Mobile(4, "LG", 35000, 7, "Great");
		System.out.println(mobile);
		mobileDAO.createMobile(mobile);
		System.out.println("\nList of mobiles is:");

		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}

		

		context.close();
	}

}