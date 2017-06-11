package service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDaoImpl;
import entity.Customer;

@Transactional
public class CustomerService {
	private CustomerDaoImpl customerDaoImpl;
	public void setCustomerDaoImpl(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}
	public List<Customer> findOne(Customer customer) {
		return customerDaoImpl.findOne(customer);
	}
	public Serializable addOne(Customer customer) {
		return customerDaoImpl.add(customer);
	}
	public List<Customer> getOne(String customerName) {
		List<Customer> customers= customerDaoImpl.getOneByName(customerName);
		return customers;
	}
	public void updateOne(Customer customer) {
		customerDaoImpl.update(customer);
	}
	public List<Customer> getAll() {
		return customerDaoImpl.getAll();
	}
	public List<Customer> getAllByLimit(int page, int rows) {
		return customerDaoImpl.getAllByLimit(page,rows);
	}
	public List<Customer> getQueryList(String birthday1, String birthday2, String name, String sex, String vocation) throws ParseException {
		return customerDaoImpl.getQueryList(birthday1,birthday2,name,sex,vocation);
	}
	public List<Customer> getQueryListLimit(int rows, int page, String birthday1, String birthday2, String name,
			String sex, String vocation) throws ParseException {
		return customerDaoImpl.getQueryListLimit(rows, page, birthday1,birthday2, name,
				sex, vocation);
	}
}
