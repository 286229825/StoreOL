package service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import entity.Customer;

@Transactional
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<Customer> findOne(Customer customer) {
		return customerDao.findOne(customer);
	}
	public Serializable addOne(Customer customer) {
		return customerDao.add(customer);
	}
	public List<Customer> getOne(String customerName) {
		List<Customer> customers= customerDao.getOneByName(customerName);
		return customers;
	}
	public void updateOne(Customer customer) {
		customerDao.update(customer);
	}
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	public List<Customer> getAllByLimit(int page, int rows) {
		return customerDao.getAllByLimit(page,rows);
	}
	public List<Customer> getQueryList(String birthday1, String birthday2, String name, String sex, String vocation) throws ParseException {
		return customerDao.getQueryList(birthday1,birthday2,name,sex,vocation);
	}
	public List<Customer> getQueryListLimit(int rows, int page, String birthday1, String birthday2, String name,
			String sex, String vocation) throws ParseException {
		return customerDao.getQueryListLimit(rows, page, birthday1,birthday2, name,
				sex, vocation);
	}
}
