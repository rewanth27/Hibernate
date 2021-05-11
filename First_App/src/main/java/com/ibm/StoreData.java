package com.ibm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class StoreData
{
  public static void main(String[] args) 
  {
	  SessionFactory sessionFactory=null;
	  
	  //configures settings from configure("hibernate.cfg.xml");
	  final StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	  
	  try
	  {
		  sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
	  }
	  catch(Exception e)
	  {
		  	StandardServiceRegistryBuilder.destroy(registry);
	  }
	  
	  Employee e1=new Employee();
	  e1.setId(1);
	  e1.setFirstName("Sai");                    
	  e1.setLastName("Rewanth");
	  System.out.println("hello...");
	  
	  Session session =sessionFactory.openSession();
	  session.persist(e1);//persisting the object
	  
	  session.beginTransaction();
	  session.getTransaction().commit();//transaction is committed
	  session.close();
	  System.out.println("Successfully created");
  }
}
