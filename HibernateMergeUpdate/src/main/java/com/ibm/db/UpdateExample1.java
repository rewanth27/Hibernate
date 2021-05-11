package com.ibm.db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import com.ibm.model.Employee;
import com.ibm.util.HibernateUtil;
 
public class UpdateExample1 
{
    public static void main(String[] args)
    {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session1 = sf.openSession();
 
        // Load the Employee details whose Id is 1
   
		Employee employee = (Employee) session1.get(Employee.class, 1);
       
        session1.close();
       
        //Update employee object, which is in detached state
        employee.setAge(45);
       
        Session session2 = sf.openSession();
        Transaction tx = session2.beginTransaction();
        session2.update(employee);
        tx.commit();
    }
 
}