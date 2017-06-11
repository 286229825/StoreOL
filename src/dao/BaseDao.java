package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	Serializable add(T t);
	void update(T t);
	void delete(T t);
	T getOne(Integer id);
	List<T> getAll();
}
