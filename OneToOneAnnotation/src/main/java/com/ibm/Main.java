package com.ibm;

import org.hibernate.*;
import java.util.*;


import com.ibm.model.Applicant;
import com.ibm.model.Passport;
import com.ibm.util.HibernateUtil;

public class Main 
{
  public static void main(String[] args) 
  {
	//Get Session Factory using Hibernate util class
	  SessionFactory sf=HibernateUtil.getSessionFactory();
	  
	//Get Session from session actory
	  Session session=sf.openSession();
	  
	  //Begin Transaction
	  Transaction t=session.beginTransaction();
	  
	  //create applicant model
	  Applicant applicant=new Applicant();
	  applicant.setName("Rewanth");
	  applicant.setAge(30);
	  applicant.setCity("Anantapur");
	  
	  //create passport model data
	  Passport passport=new Passport();
	  passport.setPassportNumber("ABCDFER123");
	  passport.setIssuedDate(new Date());
	  
	  Calendar date=Calendar.getInstance();
	  date.setTime(new Date());
	  date.add(Calendar.YEAR, 10);
	  passport.setExpiryDate(date.getTime());
	  
	  applicant.setPassport(passport);
	  passport.setApplicant(applicant);
	  session.persist(applicant);
	  
	  //commit the transaction and close the session
	  t.commit();
	  session.close();
	  System.out.println("Successfully persisted applicant details");
  }
}
