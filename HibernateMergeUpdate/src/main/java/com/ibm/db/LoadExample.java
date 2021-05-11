package com.ibm.db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import com.ibm.model.Employee;
import com.ibm.util.HibernateUtil;
 
public class LoadExample {
    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session = sf.openSession();
 
        // Load the Employee details whose Id is 1
        System.out.println("Calling Session.load() method");
        session.load(Employee.class, 1);
        session.close();
       
    }
   
 
}
