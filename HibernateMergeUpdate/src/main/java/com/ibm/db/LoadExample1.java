package com.ibm.db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import com.ibm.model.Employee;
import com.ibm.util.HibernateUtil;
 
public class LoadExample1 {
 
    public static void main(String[] args) {
 
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session = sf.openSession();
 
        // Load the Employee details whose Id is 1
        System.out.println("Calling Session.load() method");
        Employee employee = session.load(Employee.class, 10);
        System.out.println ("Employee Obj --> "+employee);
        session.close();
       
    }
}
