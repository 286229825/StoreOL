package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.Customer;
import entity.Manager;
import entity.User;

public class RoleServiceImpl implements RoleService{
	
	//注入CustomerDaoImpl对象
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//注入ManagerDaoImpl对象
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public Set<String> getRoles(String username)throws Exception{
		Set<String> set=new HashSet<String>();
		List<Customer> list = customerService.getOne(username);
		if (list != null && list.size()>0) {
			set.add("customer");
		}
		List<Manager> list2 = managerService.findOneByName(username);
		if (list2 !=null && list2.size()>0) {
			set.add("manager");
		}
		return set;
	}

	public Set<String> getPermissons(String name) throws Exception{
		Set<String> set=new HashSet<String>();
		List<Manager> list2 = managerService.findOneByName(name);
		if (list2 !=null && list2.size()>0) {
			set.add(list2.get(0).getLevel());
		}
		return set;
	}
	
	public User getUser(String username)throws Exception{
		User user=new User();
		List<Customer> list = customerService.getOne(username);
		if (list != null && list.size()>0) {
			Customer customer=list.get(0);
			user.setName(customer.getName());
			user.setPassword(customer.getPassword());
			return user;
		}
		List<Manager> list2 = managerService.findOneByName(username);
		if (list2 !=null && list2.size()>0) {
			Manager manager=list2.get(0);
			user.setName(manager.getName());
			user.setPassword(manager.getPassword());
			return user;
		}
		return null;
	}
}
