package com.ibm.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
 private static final SessionFactory sessionFactory= buildSessionFactory();
 private static SessionFactory buildSessionFactory()
 {
	 try
	 {
		 //create the sessionFactory from hibernate.cfg.xml
		 return new Configuration().configure().buildSessionFactory();
	 }
	 catch(Throwable e)
	 {
		 //Make sure you log the exception to track it
		 System.err.println("Session Fctory creation failed: "+e);
		 throw new ExceptionInInitializerError(e);
	 } 
 }
 
 public static SessionFactory getSessionFactory()
 {
	 return  sessionFactory;
 }
 
 public static void shutDown()
 {
	 //optional but can be use to close caches and connection pools
	 getSessionFactory().close();
 }
}
