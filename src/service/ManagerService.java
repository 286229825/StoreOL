package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import entity.Manager;

@Transactional
public interface ManagerService {
	public List<Manager> findOne(Manager manager);
	
	public void addOne(Manager manager);
	
	public List<Manager> getAll();
	
	public List<Manager> getAllByLimit(int page, int rows);
	
	public Manager getOne(int id);
	
	public void deleteOne(Manager manager2);
	
	public void updateOne(Manager manager);
	
	public List<Manager> findOneByName(String name);
}
