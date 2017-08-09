package service;

import java.util.List;
import java.util.Map;


import org.springframework.transaction.annotation.Transactional;
import entity.Orders;
import entity.OrdersDetail;

@Transactional
public interface OrdersService {
	public Map<Integer,OrdersDetail> getShoppingCar();
	
	public void save(Orders orders);
	
	public List<Orders> getList(String customerName);
	
	public List<Orders> getAll();
	
	public List<Orders> getAllByLimit(int page, int rows);
	
	public Orders getOne(int id);
	
	public void deleteOne(Orders orders2);
}
