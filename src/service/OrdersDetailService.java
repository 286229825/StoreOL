package service;

import org.springframework.transaction.annotation.Transactional;

import dao.OrdersDetailDaoImpl;

@Transactional
public class OrdersDetailService {
	private OrdersDetailDaoImpl ordersDetailDaoImpl;
	public void setOrdersDetailDaoImpl(OrdersDetailDaoImpl ordersDetailDaoImpl) {
		this.ordersDetailDaoImpl = ordersDetailDaoImpl;
	}
}
