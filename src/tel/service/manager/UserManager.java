package tel.service.manager;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import tel.data.model.DataConstant;
import tel.data.model.Doctor;
import tel.data.model.Patient;
import tel.data.model.User;

public class UserManager {

	private static SessionFactory factory; 
	Transaction tx;
	Session session;
	
	 private void createSessionFactory()
	 {
		 try{
			 factory = new AnnotationConfiguration().
	                   configure().
	                   addPackage("tel.data.model"). //add package if used.
	                   addAnnotatedClass(User.class).
	                   addAnnotatedClass(Doctor.class).
	                   addAnnotatedClass(Patient.class).
	                   buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	public  User logonUser(User user)
	{
		
		createSessionFactory();
		session = factory.openSession();
		Doctor doctor;
		Patient patient;
	      try{
	         tx = session.beginTransaction();
	         String hql = "FROM User D WHERE D.userName = :uName AND D.userPassword = :uPass";
	         
	         Query query = session.createQuery(hql);
	         query.setParameter("uName",user.getUserName());
	         query.setParameter("uPass",user.getUserPassword());
	         List userList = query.list();
	         user=(User)userList.get(0);
	         System.out.println("p name "+user.getFirstName());
	         if(userList.size()==1)
	         {
	        	 user=(User)userList.get(0);
	        	 if(user.getUserType()==DataConstant.USER_TYPE_PATIENT_INT)
	        	 {
	        		 System.out.println("in type pa");
	        		 hql = "FROM Patient D WHERE D.userId = :uId";
	        		 query = session.createQuery(hql);
	        		 query.setParameter("uId",user.getUserId());
	        		 userList=query.list();
	        		 tx.commit();
	        		 patient=(Patient)userList.get(0);
	        		 System.out.println("p name "+patient.getFirstName()+" "+patient.getAge());
	        		 return patient;
	        	 }
	        	 else if(user.getUserType()==DataConstant.USER_TYPE_DOCTOT_INT)
	        	 {
	        		 hql = "FROM Doctor D WHERE D.userId = :uId";
	        		 query = session.createQuery(hql);
	        		 query.setParameter("uId",user.getUserId());
	        		 userList=query.list();
	        		 tx.commit();
	        		 doctor=(Doctor)userList.get(0);
	        		 return doctor;
	        	 }	        	
	        	 
	         }
	         else
	         {
	        	 return null;
	         }
	         
	         
	        
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return null;
	}
	
}
