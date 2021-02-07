package com.hibernateDemo;

import java.util.Date;

import org.hibernate.Session;

import com.hibernateDemo.Model.Bank;

public class ApplicationMappingCollection_15 {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

			Bank bank = new Bank();
			bank.setName("HDFC");
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

			/* This is using List
			 * bank.getContacts().add("Joe"); bank.getContacts().add("Doe");
			 * bank.getContacts().add("Pinky");
			 */
			

			//This is using Map
			bank.getContacts().put("key1", "value1");
			bank.getContacts().put("key2", "value2");
			bank.getContacts().put("key3", "value3");
			
			
			
			session.save(bank);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}
