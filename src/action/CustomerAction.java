package action;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Customer;
import service.CustomerServiceImpl;
import service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//登录验证
	public String login() {
//		List<Customer> list = customerService.findOne(customer);
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpSession session=request.getSession();
//		String name=(String) session.getAttribute("customerName");
//		if(name != null) {
//			session.removeAttribute("shoppingCar");
//			session.removeAttribute("totalMoney");
//		}
//		if(list != null && list.size()>0) {
//			Customer customer2=list.get(0);
//			session.setAttribute("customerName", customer2.getName());
//			request.setAttribute("islogin", "登录成功，现在开始购物吧！");
//			return "index";
//		}
//		request.setAttribute("message", "对不起，帐号或密码错误！");
//		return "index";
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(customer.getName(), customer.getPassword());
		try {
			subject.login(token);
			String name=(String) session.getAttribute("customerName");
			if(name != null) {
				session.removeAttribute("shoppingCar");
				session.removeAttribute("totalMoney");
			}
			List<Customer> list = customerService.findOne(customer);
			session.setAttribute("customerName", list.get(0).getName());
			request.setAttribute("islogin", "登录成功，现在开始购物吧！");
			return "index";
		} catch (Exception e) {
			request.setAttribute("message", "对不起，帐号或密码错误！");
			return "index";
		}
	}
	
	//校验登录名是否存在
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String checkName() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String name = request.getParameter("name");
		List<Customer> customers = customerService.getOne(name);
		boolean flag2=true;
		if(customers.size() > 0) {
			flag2=false;
		}
		this.setFlag(flag2);
		return "flag";
	}
	
	//注册
	public String signIn() {
		customerService.addOne(customer);
		return "success";
	}
	
	//退出登录
	public String logout() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("customerName");
		request.getSession().removeAttribute("shoppingCar");
		request.getSession().removeAttribute("totalMoney");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "indexRedirect";
	}
	
	
	//到资料修改的页面
	public String toeditInfo() {
		return "editInfo";
	}
	
	//资料修改
	public String editInfo() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String customerName=(String) session.getAttribute("customerName");
		List<Customer> list = customerService.getOne(customerName);
		Customer customer2=list.get(0);
		customer2.setBirthday(customer.getBirthday());
		customer2.setEmail(customer.getEmail());
		customer2.setName(customer.getName());
		customer2.setPassword(customer.getPassword());
		customer2.setRealName(customer.getRealName());
		customer2.setSex(customer.getSex());
		customer2.setVocation(customer.getVocation());
		String customerName2=customer.getName();
		session.setAttribute("customerName", customerName2);
		customerService.updateOne(customer2);
		return "successEdit";
	}
	
	//到顾客列表页面
	public String toList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/customerList.jsp");
		return "Managerindex";
	}
	
	//获取顾客列表
	private Map<String, Object> customerListLimit;
	public Map<String, Object> getCustomerListLimit() {
		return customerListLimit;
	}
	public void setCustomerListLimit(Map<String, Object> customerListLimit) {
		this.customerListLimit = customerListLimit;
	}
	public String getCustomerList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		List<Customer> list=customerService.getAll();
		List<Customer> list2=customerService.getAllByLimit(page,rows);
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("rows", list2);
		int total=list.size();
		map.put("total", total);
		this.setCustomerListLimit(map);
		return "customerListLimit";
	}
	
	//到查询页面
	public String toQuery() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("myurl", request.getContextPath()+"/manager/cutomerQuery.jsp");
		return "Managerindex";
	}
	
	//获取查询结果
	private Map<String, Object> queryList;
	public Map<String, Object> getQueryList() {
		return queryList;
	}
	public void setQueryList(Map<String, Object> queryList) {
		this.queryList = queryList;
	}
	public String getQueryResult() throws ParseException {
		HttpServletRequest request=ServletActionContext.getRequest();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		String birthday1 = request.getParameter("birthday1");
		String birthday2 = request.getParameter("birthday2");
		String name = request.getParameter("myname");
		String sex = request.getParameter("mysex");
		String vocation = request.getParameter("myvocation");
		List<Customer> list = customerService.getQueryList(birthday1,birthday2,name,sex,vocation);
		List<Customer> list2 = customerService.getQueryListLimit(rows,page,birthday1,birthday2,name,sex,vocation);
		int total=list.size();
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("rows", list2);
		map.put("total", total);
		this.setQueryList(map);
		return "queryList";
	}
}
