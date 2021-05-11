package com.ibm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ibm.model.Address;
import com.ibm.model.Person;
import com.ibm.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("KC");
		person.setAge(28);
		person.setEducation("Graduation");
		
		Address currentAdd = new Address();
		currentAdd.setStreet("Royal road");
		currentAdd.setCity("Newyork");
		currentAdd.setZipcode("10001");
		
		currentAdd.setPerson(person);
		Address permanentAdd = new Address();
		permanentAdd.setStreet("Manyar Road");
		permanentAdd.setCity("Sydney");
		permanentAdd.setZipcode("2060");
		
		permanentAdd.setPerson(person);
		
		session.persist(person);
		session.persist(currentAdd);
		session.persist(permanentAdd);
		t.commit();
		session.close();
		System.out.println("Successfully persisted person details");
		
	}

}
