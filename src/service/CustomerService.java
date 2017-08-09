package service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import entity.Customer;

public interface CustomerService {

	public List<Customer> findOne(Customer customer);
	
	public Serializable addOne(Customer customer);
	
	public List<Customer> getOne(String customerName);
	
	public void updateOne(Customer customer);
	
	public List<Customer> getAll();
	
	public List<Customer> getAllByLimit(int page, int rows);
	
	public List<Customer> getQueryList(String birthday1, String birthday2, String name, String sex, String vocation) throws ParseException;
	
	public List<Customer> getQueryListLimit(int rows, int page, String birthday1, String birthday2, String name,
			String sex, String vocation) throws ParseException;
}
