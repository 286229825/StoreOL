package service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import dao.OrdersDao;
import entity.Orders;
import entity.OrdersDetail;

@Transactional
public class OrdersServiceImpl implements OrdersService{
	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	public Map<Integer,OrdersDetail> getShoppingCar() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer,OrdersDetail> shoppingCar = (Map<Integer,OrdersDetail>) session.getAttribute("shoppingCar");
		if(shoppingCar == null) {
			shoppingCar = new LinkedHashMap<Integer,OrdersDetail>();
			session.setAttribute("shoppingCar", shoppingCar);
		}
		return shoppingCar;
	}
	public void save(Orders orders) {
		ordersDao.add(orders);
	}
	public List<Orders> getList(String customerName) {
		return ordersDao.getList(customerName);
	}
	public List<Orders> getAll() {
		return ordersDao.getAll();
	}
	public List<Orders> getAllByLimit(int page, int rows) {
		return ordersDao.getAllByLimit(page,rows);
	}
	public Orders getOne(int id) {
		return ordersDao.getOne(id);
	}
	public void deleteOne(Orders orders2) {
		ordersDao.delete(orders2);
	}
}
