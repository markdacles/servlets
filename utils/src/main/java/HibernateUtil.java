import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import java.sql.SQLException;
import java.io.*;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static Session currentSession;
    private static Transaction currentTransaction;

    public HibernateUtil() {
    }
  
    private static SessionFactory buildSessionFactory() {
        try {
          return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
          System.err.println("Initial SessionFactory creation failed." + ex);
          throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void closeCurrentSession() {
        currentSession.close();
    }

    public static Session openCurrentSessionWithTrans() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public static Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public static void closeCurrentSessionWithTrans() {
        currentTransaction.commit();
        currentSession.close();
    }

    public static void shutDown() {
        sessionFactory.close();
    }

}