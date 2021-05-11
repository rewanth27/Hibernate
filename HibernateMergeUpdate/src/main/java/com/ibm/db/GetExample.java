package com.ibm.db;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import com.ibm.model.Employee;
import com.ibm.util.HibernateUtil;
 
public class GetExample {
    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session = sf.openSession();
 
        // Get the Employee details whose Id is 1
        System.out.println("Calling Session.get() method");
        System.out.println(session.get(Employee.class, 1));
        session.close();
       
    }
 
}