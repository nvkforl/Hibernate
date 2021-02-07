package com.hibernateDemo;

import java.util.Date;

import org.hibernate.Session;

import com.hibernateDemo.Model.Address;
import com.hibernateDemo.Model.User;

public class ApplicationOverrideEmbeded {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

			User user = new User();
			user.setAge(22);
			user.setBirthDate(new Date());
			user.setCreatedBy("kmb");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kmb385");
			user.setFirstName("Kevin");
			user.setLastName("bowersox");
			user.setLastUpdatedBy("kevin");
			user.setLastUpdatedDate(new Date());

			Address address = new Address();
			address.setAddressLine1("Line 1");
			address.setAddressLine2("Line 2");
			address.setCity("New York");
			address.setState("NY");
			address.setZipCode("12345");

			user.setAddress(address);
			session.save(user);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}
