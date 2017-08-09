package dao;

import java.util.List;

import entity.Orders;

public interface OrdersDao extends BaseDao<Orders> {

	public List<Orders> getList(String customerName);
	
	public List<Orders> getAllByLimit(int page, int rows);
}
