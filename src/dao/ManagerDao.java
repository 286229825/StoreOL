package dao;

import java.util.List;

import entity.Manager;

public interface ManagerDao extends BaseDao<Manager> {
	public List<Manager> findOne(Manager manager);
	
	public List<Manager> getAllByLimit(int page, int rows);

	public List<Manager> findOneByName(String name);
}
