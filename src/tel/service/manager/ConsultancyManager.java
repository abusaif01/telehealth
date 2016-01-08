package tel.service.manager;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;





public class ConsultancyManager {

	private static SessionFactory factory;
	Session session;
	Transaction transaction;
	
	private void createSessionFactory()
	{
		 try{
			 factory = new AnnotationConfiguration().
	                   configure().
	                   addPackage("tel.data.model"). //add package if used.
	                  // addAnnotatedClass(Disease.class).
	                   buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	
	public List getDiseasList()
	{
		List diseasList=null;
		createSessionFactory();
		session=factory.openSession();
		transaction=null;
		

		try {
			transaction=session.beginTransaction();
			String hql = "FROM Disease";
			Query query = session.createQuery(hql);
			diseasList = query.list();
			transaction.commit();
			return diseasList;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			 if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
		}finally
		{
			session.close();
		}
		return diseasList;
	}
	

}
