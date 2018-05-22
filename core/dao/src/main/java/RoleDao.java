import java.time.*;
import java.util.*;

public class RoleDao {

	public RoleDao() {
	}

	 public List<Roles> findAll() {
		  HibernateUtil.openCurrentSession();
	    List<Roles> roleList = (List<Roles>) HibernateUtil.getCurrentSession().createQuery("from Roles").setCacheable(true).list();
	    HibernateUtil.closeCurrentSession();
	    return roleList;
  	}

  	public void addRole(Roles r) {
  		HibernateUtil.openCurrentSession();
  		HibernateUtil.getCurrentSession().save(r);
  		HibernateUtil.closeCurrentSession();
  	}

  	public void roleUpdate(Roles r) {
  		HibernateUtil.openCurrentSessionWithTrans();
  		HibernateUtil.getCurrentSession().update(r);
  		HibernateUtil.closeCurrentSessionWithTrans();
  	}

  	public void deleteRole(Long id) {
  		HibernateUtil.openCurrentSessionWithTrans();
  		Roles role = (Roles) HibernateUtil.getCurrentSession().get(Roles.class, id);
  		HibernateUtil.getCurrentSession().delete(role);
  		HibernateUtil.closeCurrentSessionWithTrans();
  	}

    public Roles findById(Long id) {
      HibernateUtil.openCurrentSession();
      Roles role = (Roles) HibernateUtil.getCurrentSession().get(Roles.class, id);
      HibernateUtil.closeCurrentSession();
      return role;
    }
}