package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import entity.Manager;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

	public List<Manager> findOne(Manager manager) {
		return (List<Manager>) super.getHibernateTemplate().find("from Manager where name=? and password=?", manager.getName(),manager.getPassword());
	}

	public List<Manager> getAllByLimit(int page, int rows) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Manager.class);
		List<Manager> list=(List<Manager>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}

}
