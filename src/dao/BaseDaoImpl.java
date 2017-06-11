package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class<T> clazz;
	public BaseDaoImpl() {
		Type type=getClass().getGenericSuperclass();
		ParameterizedType parameterizedType=(ParameterizedType) type;
		Type[] types = parameterizedType.getActualTypeArguments();
		clazz=(Class<T>) types[0];
	}

	public Serializable add(T t) {
		return super.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		super.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		super.getHibernateTemplate().delete(t);
	}

	public T getOne(Integer id) {
		return super.getHibernateTemplate().get(clazz, id);
	}

	public List<T> getAll() {
		return (List<T>) super.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

}
