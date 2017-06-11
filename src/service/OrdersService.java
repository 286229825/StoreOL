package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import dao.OrdersDaoImpl;
import entity.Orders;
import entity.OrdersDetail;

@Transactional
public class OrdersService {
	private OrdersDaoImpl ordersDaoImpl;
	public void setOrdersDaoImpl(OrdersDaoImpl ordersDaoImpl) {
		this.ordersDaoImpl = ordersDaoImpl;
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
		ordersDaoImpl.add(orders);
	}
	public List<Orders> getList(String customerName) {
		return ordersDaoImpl.getList(customerName);
	}
	public List<Orders> getAll() {
		return ordersDaoImpl.getAll();
	}
	public List<Orders> getAllByLimit(int page, int rows) {
		return ordersDaoImpl.getAllByLimit(page,rows);
	}
	public Orders getOne(int id) {
		return ordersDaoImpl.getOne(id);
	}
	public void deleteOne(Orders orders2) {
		ordersDaoImpl.delete(orders2);
	}
}
