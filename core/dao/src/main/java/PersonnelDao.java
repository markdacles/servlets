import java.time.*;
import java.util.*;

public class PersonnelDao {

	public PersonnelDao() {
	}

  	public void addPersonnel(Personnel p) {
  		HibernateUtil.openCurrentSessionWithTrans();
  		HibernateUtil.getCurrentSession().save(p);
  		HibernateUtil.closeCurrentSessionWithTrans();
  	}

  	public List<Personnel> findAll() {
		HibernateUtil.openCurrentSession();
    List<Personnel> personnelList = (List<Personnel>) HibernateUtil.getCurrentSession().createQuery("from Personnel").setCacheable(true).list();
    HibernateUtil.closeCurrentSession();
    return personnelList;
  	}

    public Personnel getPersonnel(Long id) {
      HibernateUtil.openCurrentSession();
      Personnel personnel = (Personnel) HibernateUtil.getCurrentSession().get(Personnel.class, id);
      HibernateUtil.closeCurrentSession();
      return personnel;
    }

    public void personnelUpdate(Personnel p) {
      HibernateUtil.openCurrentSessionWithTrans();
      HibernateUtil.getCurrentSession().update(p);
      HibernateUtil.closeCurrentSessionWithTrans();
    }

    public void deletePersonnel(Long id) {
      HibernateUtil.openCurrentSessionWithTrans();
      Personnel p = (Personnel) HibernateUtil.getCurrentSession().get(Personnel.class, id);
      HibernateUtil.getCurrentSession().delete(p);
      HibernateUtil.closeCurrentSessionWithTrans();
    }

    public Personnel findById(Long id) {
      HibernateUtil.openCurrentSession();
      Personnel personnel = (Personnel) HibernateUtil.getCurrentSession().get(Personnel.class, id);
      System.out.println("ping"); 
      HibernateUtil.closeCurrentSession();
      return personnel;
    }

    public boolean checkPerson(Long id) {
      HibernateUtil.openCurrentSession();
      Personnel personnel = (Personnel) HibernateUtil.getCurrentSession().get(Personnel.class, id);
      HibernateUtil.closeCurrentSession();
      if(personnel == null) {
        return false;
      } else {
        return true;
      }
    }

    public void addContactToPersonnel(Personnel p) {
      HibernateUtil.openCurrentSessionWithTrans();
      HibernateUtil.getCurrentSession().update(p);
      HibernateUtil.closeCurrentSessionWithTrans();
    }

    public void contactUpdate(Personnel p) {
      HibernateUtil.openCurrentSessionWithTrans();
      HibernateUtil.getCurrentSession().update(p);
      HibernateUtil.closeCurrentSessionWithTrans();
    }

    public void removeContact(Personnel p) {
      HibernateUtil.openCurrentSessionWithTrans();
      HibernateUtil.getCurrentSession().update(p);
      HibernateUtil.closeCurrentSessionWithTrans();
    }
}