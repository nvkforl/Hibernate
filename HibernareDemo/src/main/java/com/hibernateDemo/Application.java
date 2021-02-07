package com.hibernateDemo;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.hibernateDemo.Model.Bank;
import com.hibernateDemo.Model.TimeTest;
import com.hibernateDemo.Model.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

		/*
		 * User user = new User(); user.setFirstName("nikolo");
		 * user.setLastName("kkkk"); user.setBirthDate(new Date());
		 * user.setCreatedBy("Ramesh"); user.setCreatedDate(new Date());
		 * user.setEmailAddress("asdf@gmail.com"); user.setLastUpdatedBy("Rambo");
		 * user.setLastUpdatedDate(new Date());
		 * 
		 * session.save(user); session.getTransaction().commit();
		 */

		// using updatable annotation in user
		// update FINANCES_USER set BIRTH_DATE=?, EMAIL_ADDRESS=?, FIRST_NAME=?,
		// LAST_NAME=?, LAST_UPDATED_BY=?, LAST_UPDATED_DATE=? where USER_ID=?
		// update did not happen on CREATED_DATE and CREATED_BY as the fields are
		// unupdatable
		/*
		 * session.beginTransaction(); User dbUser = (User) session.get(User.class,
		 * user.getUserId()); dbUser.setFirstName("Joe"); session.update(dbUser);
		 * session.getTransaction().commit();
		 */

		// use of Temporal anottation
		/*
		 * TimeTest timeTest = new TimeTest(new Date()); session.save(timeTest);
		 * session.getTransaction().commit(); session.refresh(timeTest);
		 * 
		 * System.out.println(timeTest.toString());
		 */

		// use of formula annotation
		/*
		 * User user = new User(); user.setFirstName("nikolo");
		 * user.setLastName("kkkk"); user.setBirthDate(getMyBirthDay());
		 * user.setCreatedBy("Ramesh"); user.setCreatedDate(new Date());
		 * user.setEmailAddress("asdf@gmail.com"); user.setLastUpdatedBy("Rambo");
		 * user.setLastUpdatedDate(new Date());
		 * 
		 * session.save(user); session.getTransaction().commit(); session.refresh(user);
		 * System.out.println(user.getAge());
		 */
		
		//using @Embeded annotaion on address object
		Bank bank = new Bank();
		bank.setName("ICICI");
		bank.setAddressLine1("AddressLine1");
		bank.setAddressLine2("AddressLine2");
		bank.setCity("Bangalore");
		bank.setState("KA");
		bank.setZipCode("2541239");
		bank.setCreatedBy("Rambo Ramesh");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("ramesh");
		bank.setLastUpdatedDate(new Date());
		bank.setInternational(Boolean.FALSE);
		session.save(bank);
		session.getTransaction().commit();
		session.refresh(bank);
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

	private static Date getMyBirthDay() {
		Calendar calander = Calendar.getInstance();
		calander.set(calander.YEAR, 1984);
		calander.set(calander.MONTH, 6);
		calander.set(calander.DATE, 19);
		return calander.getTime();
	}

}
