package com.ibm;

import java.util.*;

import org.hibernate.*;
import com.ibm.util.HibernateUtil;
import com.ibm.model.*;
public class Main
{
	public static void main(String[] args) 
	{
	  //Get Session factory using hibernate util class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
      //Get session object from session factory
	    Session session = sf.openSession();
	    
	    //Begin transaction
	    Transaction t=session.beginTransaction();
	    
	    //create Bank model data
	    Bank bank1=new Bank();
	    bank1.setName("HDFC");
	    bank1.setBranchName("Bangalore");
	    bank1.setSwiftCode("ABCDEFGHI");
	    
	    Bank bank2 = new Bank();
        bank2.setName("Bank Of America");
        bank2.setBranchName("California");
        bank2.setSwiftCode("BOFAUS3N");
       
        Set<Bank> banks = new HashSet<>();
        banks.add(bank1);
        banks.add(bank2);
 
        Customer customer1 = new Customer();
        customer1.setEmail("john@gmail.com");
        customer1.setName("John");
        customer1.setMobileNo(9999999999l);
       
        Customer customer2 = new Customer();
        customer2.setEmail("Peter@gmail.com");
        customer2.setName("Peter");
        customer2.setMobileNo(8888888888l);
       
        Customer customer3 = new Customer();
        customer3.setEmail("James@gmail.com");
        customer3.setName("James");
        customer3.setMobileNo(7777777777l);
       
        Customer customer4 = new Customer();
        customer4.setEmail("Raj@gmail.com");
        customer4.setName("Raj");
        customer4.setMobileNo(6666666666l);
       
       
        Set<Customer> customersList1 = new HashSet<>();
        customersList1.add(customer1);
        customersList1.add(customer2);
        bank1.setCustomers(customersList1);
       
        Set<Customer> customersList2 = new HashSet<>();
        customersList2.add(customer2);
        customersList2.add(customer3);
        customersList2.add(customer4);
        bank2.setCustomers(customersList2);
       
        session.save(bank1);
        session.save(bank2);
 
        // Commit the transaction and close the session
        t.commit();
        session.close();
        System.out.println("successfully persisted Bank and Customer details");
	}
}
