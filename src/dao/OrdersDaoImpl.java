package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import entity.Orders;

public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {

	public List<Orders> getList(String customerName) {
		List<Orders> list = (List<Orders>) super.getHibernateTemplate().find("from Orders where customer.name=?", customerName);
		return list;
	}

	public List<Orders> getAllByLimit(int page, int rows) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Orders.class);
		List<Orders> list=(List<Orders>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}
}
