package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import entity.Notice;

public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao {

	public List<Notice> getAllByLimit(int page, int rows) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		List<Notice> list=(List<Notice>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}

}
