package dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	public List<Customer> findOne(Customer customer) {
		return (List<Customer>) super.getHibernateTemplate().find("from Customer where name=? and password=?", customer.getName(),customer.getPassword());
	}

	public List<Customer> getOneByName(String customerName) {
		List<Customer> list = (List<Customer>) super.getHibernateTemplate().find("from Customer where name=?", customerName);
		return list;
	}

	public List<Customer> getAllByLimit(int page, int rows) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		List<Customer> list=(List<Customer>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}

	public List<Customer> getQueryList(String birthday1, String birthday2, String name, String sex, String vocation) throws ParseException {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		if(birthday1 != "" && birthday2 != "") {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			long time1 = dateFormat.parse(birthday1).getTime();
			long time2 = dateFormat.parse(birthday2).getTime();
			Date date1=new Date(time1);
			Date date2=new Date(time2);
			criteria.add(Restrictions.between("birthday", date1, date2));
		}
		if(name != "") {
			criteria.add(Restrictions.like("name", "%"+name+"%"));
		}
		if(vocation != "") {
			criteria.add(Restrictions.like("vocation", "%"+vocation+"%"));
		}
		if(sex != "") {
			criteria.add(Restrictions.eq("sex", sex));
		}
		List<Customer> list=(List<Customer>) super.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	public List<Customer> getQueryListLimit(int rows, int page, String birthday1, String birthday2, String name,
			String sex, String vocation) throws ParseException {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		if(birthday1 != "" && birthday2 != "") {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			long time1 = dateFormat.parse(birthday1).getTime();
			long time2 = dateFormat.parse(birthday2).getTime();
			Date date1=new Date(time1);
			Date date2=new Date(time2);
			criteria.add(Restrictions.between("birthday", date1, date2));
		}
		if(name != "") {
			criteria.add(Restrictions.like("name", "%"+name+"%"));
		}
		if(vocation != "") {
			criteria.add(Restrictions.like("vocation", "%"+vocation+"%"));
		}
		if(sex != "") {
			criteria.add(Restrictions.eq("sex", sex));
		}
		List<Customer> list=(List<Customer>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}

}
