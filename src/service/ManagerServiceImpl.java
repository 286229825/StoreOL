package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.ManagerDao;
import entity.Manager;

@Transactional
public class ManagerServiceImpl implements ManagerService{
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	public List<Manager> findOne(Manager manager) {
		return managerDao.findOne(manager);
	}
	public void addOne(Manager manager) {
		managerDao.add(manager);
	}
	public List<Manager> getAll() {
		return managerDao.getAll();
	}
	public List<Manager> getAllByLimit(int page, int rows) {
		return managerDao.getAllByLimit(page,rows);
	}
	public Manager getOne(int id) {
		return managerDao.getOne(id);
	}
	public void deleteOne(Manager manager2) {
		managerDao.delete(manager2);
	}
	public void updateOne(Manager manager) {
		managerDao.update(manager);
	}
	
	public List<Manager> findOneByName(String name){
		return managerDao.findOneByName(name);
	}
}
