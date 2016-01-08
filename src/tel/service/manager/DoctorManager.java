package tel.service.manager;

import org.hibernate.SessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.HashMap;
import java.util.List;

import tel.data.model.Doctor;
import tel.data.model.Message;


public class DoctorManager {

	private static SessionFactory factory;
	Session session;
	Transaction transaction;
	
	
	private void createSessionFactory()
	 {
		 try{
			 factory = new AnnotationConfiguration().
	                   configure().
	                   //addPackage("tel.data.model"). //add package if used.
	                   addAnnotatedClass(Doctor.class).
	                   buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 
	public void addDoctor(Doctor doctor)
	{
		createSessionFactory();
		session=factory.openSession();
		transaction=null;
		
		try {
			transaction=session.beginTransaction();
			session.save(doctor);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			 if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
		}finally
		{
			session.close();
		}
	}
	
	public List getDoctorsList()
	{
		List docotorList=null;
		 createSessionFactory();
			session=factory.openSession();
			transaction=null;
			
			try {
				transaction=session.beginTransaction();
				String hql = "FROM Doctor";
				Query query = session.createQuery(hql);
				docotorList = query.list();
				transaction.commit();
				return docotorList;
				
			} catch (HibernateException e) {
				// TODO: handle exception
				 if (transaction!=null) transaction.rollback();
		         e.printStackTrace(); 
			}finally
			{
				session.close();
			}
		 
		return docotorList;
	}
	
	
	
}
