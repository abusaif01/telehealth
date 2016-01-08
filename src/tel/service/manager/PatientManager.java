package tel.service.manager;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import tel.data.model.Patient;

public class PatientManager  {

	private static SessionFactory factory; 
	
	
	
	 private void createSessionFactory()
	 {
		 try{
			 factory = new AnnotationConfiguration().
	                   configure().
	                   //addPackage("tel.data.model"). //add package if used.
	                   addAnnotatedClass(Patient.class).
	                   buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 
	public void addPatient(Patient patient)
	{
		createSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;	
		try {
			transaction=session.beginTransaction();
			session.save(patient);
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
	
//	public  Doctor logonUser(Doctor doctor)
//	{
//		Transaction tx = null;
//		createSessionFactory();
//		Session session = factory.openSession();
//	     
//	      try{
//	         tx = session.beginTransaction();
//	         String hql = "FROM Doctor D WHERE D.userName = :uName AND D.userPassword = :uPass";
//	         
//	         Query query = session.createQuery(hql);
//	         query.setParameter("uName", doctor.getUserName());
//	         query.setParameter("uPass", doctor.getUserPassword());
//	         List user = query.list();
//	         user.size();
//	         tx.commit();
//	         if(user.size()==1)
//	         {
//	        	 doctor=(Doctor)user.get(0);
//	        	 System.out.println("in m "+doctor.getFirstName()+" "+doctor.getLastName());
//	        	 return doctor;
//	         }
//	         else
//	         {
//	        	 return null;
//	         }
//	         
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//		return null;
//	}
	
}
