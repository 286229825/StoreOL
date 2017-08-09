package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Orders;
import service.OrdersService;

public class OrdersManageAction extends ActionSupport implements ModelDriven<Orders> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Orders orders=new Orders();
	public Orders getModel() {
		return orders;
	}
	private OrdersService ordersService;
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	//到订单列表页面
	public String toList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/ordersList.jsp");
		return "index";
	}
	
	//获取订单列表
	private Map<String,Object> ordersList;
	public Map<String, Object> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(Map<String, Object> ordersList) {
		this.ordersList = ordersList;
	}
	public String getList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		List<Orders> list=ordersService.getAll();
		List<Orders> list2=ordersService.getAllByLimit(page,rows);
		int total=list.size();
		Map<String, Object> map=new HashMap<>();
		map.put("total", total);
		map.put("rows", list2);
		this.setOrdersList(map);
		return "ordersList";
	}
	
	//删除一条记录
	public String deleteOne() {
		int id=orders.getId();
		Orders orders2= ordersService.getOne(id);
		ordersService.deleteOne(orders2);
		return "backToList";
	}
	
	//到订单详细信息页面
	public String toGetDetails() {
		int id=orders.getId();
		Orders orders2 = ordersService.getOne(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orders", orders2);
		return "ordersDetails";
	}
}
