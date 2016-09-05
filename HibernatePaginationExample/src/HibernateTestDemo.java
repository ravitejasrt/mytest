

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class HibernateTestDemo {
    /**
     * @param args
     */
	static Logger log=Logger.getLogger(HibernateTestDemo.class.getName());
    public static void main(String[] args) 
    {

    	Employee emp=new Employee();
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); //Creating a session factory object
        Session session = sessionFactory.openSession(); //Creating a session object for inserting users  object to the database table USER_TABLE
        session.beginTransaction(); //Open the transaction of session object to do something

        emp = null;  //Now getting a user object from database table from session object
        session = sessionFactory.openSession(); //Creating a new session object for fetching user object
        session.beginTransaction(); //Again Open the transaction of the session object
        
        emp = (Employee) session.get(Employee.class, 1); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
        
        System.out.println(emp);
    }
}