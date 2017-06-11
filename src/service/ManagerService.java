package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.ManagerDaoImpl;
import entity.Manager;

@Transactional
public class ManagerService {
	private ManagerDaoImpl managerDaoImpl;
	public void setManagerDaoImpl(ManagerDaoImpl managerDaoImpl) {
		this.managerDaoImpl = managerDaoImpl;
	}
	public List<Manager> findOne(Manager manager) {
		return managerDaoImpl.findOne(manager);
	}
	public void addOne(Manager manager) {
		managerDaoImpl.add(manager);
	}
	public List<Manager> getAll() {
		return managerDaoImpl.getAll();
	}
	public List<Manager> getAllByLimit(int page, int rows) {
		return managerDaoImpl.getAllByLimit(page,rows);
	}
	public Manager getOne(int id) {
		return managerDaoImpl.getOne(id);
	}
	public void deleteOne(Manager manager2) {
		managerDaoImpl.delete(manager2);
	}
	public void updateOne(Manager manager) {
		managerDaoImpl.update(manager);
	}
}
