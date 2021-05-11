package com.ibm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionfactory = buildSessionFactory();
	  
	  private static SessionFactory buildSessionFactory() {
		  try {
			  //create session factory from hibernate.cfg.xml
			  
			  return new Configuration().configure().buildSessionFactory();  
		  }
		  catch(Throwable ex) {
			  System.err.println("session factory creation failed" +ex);
			  throw new ExceptionInInitializerError(ex);
		  }
	  }
	  public static SessionFactory getSessionFactory() {
		  return sessionfactory;
	  }
	  public static void shutdown()
	  {
		  //optional but we use to close caches and connections pools
		  getSessionFactory().close();
	  }
	}