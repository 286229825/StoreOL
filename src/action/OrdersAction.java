package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.Customer;
import entity.Goods;
import entity.GoodsType;
import entity.Orders;
import entity.OrdersDetail;
import service.CustomerService;
import service.GoodsService;
import service.OrdersService;

public class OrdersAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private OrdersService ordersService;
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	private GoodsService goodsService;
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String addToshoppingCar() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		Map<Integer, OrdersDetail> shoppingCar=ordersService.getShoppingCar();
		OrdersDetail ordersDetail = shoppingCar.get(goodsid);
		if(ordersDetail == null) {
			ordersDetail=new OrdersDetail();
			Goods goods=goodsService.getOne(goodsid);
			String type = goods.getGoodsType().getType();
			GoodsType goodsType=new GoodsType();
			goodsType.setType(type);
			goods.setGoodsType(goodsType);
			ordersDetail.setGoods(goods);
			ordersDetail.setNumber(0);
		}
		ordersDetail.setNumber(ordersDetail.getNumber()+1);
		float number=ordersDetail.getNumber();
		if(ordersDetail.getGoods().getIfSale()==1) {
			float money=ordersDetail.getGoods().getSalePrice()*number;
			ordersDetail.setMoney(money);
		}else {
			float money=ordersDetail.getGoods().getNowPrice()*number;
			ordersDetail.setMoney(money);
		}
		shoppingCar.put(goodsid, ordersDetail);
		Set<Integer> keySet=shoppingCar.keySet();
		Iterator<Integer> it=keySet.iterator();
		float totalMoney=0;
		while(it.hasNext()) {
			Integer key=it.next();
			OrdersDetail ordersDetail2=shoppingCar.get(key);
			totalMoney+=ordersDetail2.getMoney();
		}
		request.getSession().setAttribute("totalMoney", totalMoney);
		this.setFlag(true);
		return "flag";
	}
	
	public String toShopingCar() {
		return "shoppingCar";
	}
	
	private Map<String, Object> strs;
	public Map<String, Object> getStrs() {
		return strs;
	}
	public void setStrs(Map<String, Object> strs) {
		this.strs = strs;
	}
	public String carChange() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		int number=Integer.parseInt(request.getParameter("number"));
		HttpSession session=request.getSession();
		Map<Integer,OrdersDetail> map = (Map<Integer,OrdersDetail>) session.getAttribute("shoppingCar");
		OrdersDetail ordersDetail = map.get(goodsid);
		Float money=null;
		int ifsale = ordersDetail.getGoods().getIfSale();
		if(ifsale == 1) {
			float number2=number;
			money=ordersDetail.getGoods().getSalePrice()*number2;
		}else {
			float number2=number;
			money=ordersDetail.getGoods().getNowPrice()*number2;
		}
		Map<String,Object> map2=new HashMap<String,Object>();
		ordersDetail.setMoney(money);
		ordersDetail.setNumber(number);
		Set<Integer> keySet=map.keySet();
		Iterator<Integer> it=keySet.iterator();
		float totalMoney=0;
		while(it.hasNext()) {
			Integer key=it.next();
			OrdersDetail ordersDetail2=map.get(key);
			totalMoney+=ordersDetail2.getMoney();
		}
		session.setAttribute("totalMoney", totalMoney);
		map2.put("money", money);
		map2.put("goodsid", goodsid);
		map2.put("totalMoney", totalMoney);
		this.setStrs(map2);
		return "strs";
	}
	
	public String deleteCar() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		float totalMoney=(float) session.getAttribute("totalMoney");
		int goodsid= Integer.parseInt(request.getParameter("goodsid"));
		Map<Integer, OrdersDetail> map = (Map<Integer, OrdersDetail>) session.getAttribute("shoppingCar");
		OrdersDetail ordersDetail = map.get(goodsid);
		if(ordersDetail != null) {
			float money = ordersDetail.getMoney();
			totalMoney=totalMoney-money;
			map.remove(goodsid);
			session.setAttribute("totalMoney",totalMoney);
		}
		return "shoppingCar";
	}
	
	public String emptyShoppingCar() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Map<Integer, OrdersDetail> map=(Map<Integer, OrdersDetail>) request.getSession().getAttribute("shoppingCar");
		map.clear();
		request.getSession().setAttribute("totalMoney", 0);
		return "shoppingCar";
	}
	
	public String toAccounts() {
		return "accounts";
	}
	
	public String accounts() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer, OrdersDetail> map=(Map<Integer, OrdersDetail>) session.getAttribute("shoppingCar");
		Set<Integer> keySet=map.keySet();
		Iterator<Integer> it=keySet.iterator();
		Set<OrdersDetail> ordersDetails=new HashSet<OrdersDetail>();
		Orders orders=new Orders();
		while(it.hasNext()) {
			Integer key=it.next();
			OrdersDetail ordersDetail=map.get(key);
			ordersDetail.setOrders(orders);
			orders.getSetOrdersDetail().add(ordersDetail);
		}
		String address=request.getParameter("address");
		orders.setAddress(address);
		String phone=request.getParameter("phone");
		orders.setPhone(phone);
		String payMent=request.getParameter("payMent");
		orders.setPayMent(payMent);
		String postMethod=request.getParameter("postMethod");
		orders.setPostMethod(postMethod);
		String remarks=request.getParameter("remarks");
		orders.setRemarks(remarks);
		float totalMoney=(float) session.getAttribute("totalMoney");
		orders.setTotalMoney(totalMoney);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		orders.setCreatTime(timestamp);
		orders.setIfPost(2);
		String customerName = (String) session.getAttribute("customerName");
		List<Customer> customers = customerService.getOne(customerName);
		orders.setCustomer(customers.get(0));
		ordersService.save(orders);
		map.clear();
		return "success";
	}
	
	public String toCheckOrders() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String customerName=(String) session.getAttribute("customerName");
		List<Orders> ordersList = ordersService.getList(customerName);
		request.setAttribute("ordersList", ordersList);
		return "CheckOrders";
	}
}
