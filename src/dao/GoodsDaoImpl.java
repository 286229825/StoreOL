package dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entity.Goods;

public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

	public List<Goods> getByLimit(int page) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		List<Goods> list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*8, 8);
		return list;
	}

	public List<Goods> getAllBySale(String str) {
		List<Goods> list = null;
		if(str.equals("ifsale")) {
			list =(List<Goods>) super.getHibernateTemplate().find("from Goods where ifSale=?", 1);
		}else if(str.equals("buyTimes")) {
			list =(List<Goods>) super.getHibernateTemplate().find("from Goods order by buyTimes asc");
		}else {
			list=(List<Goods>) super.getHibernateTemplate().find("from Goods where goodsType.id=?", Integer.parseInt(str));
		}
		return list;
	}

	public List<Goods> getByLimitBySale(int page, String str) {
		List<Goods> list = null;
		if(str.equals("ifsale")) {
			DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
			criteria.add(Restrictions.eq("ifSale", 1));
			list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*8, 8);
		}else if(str.equals("buyTimes")) {
			DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
			criteria.addOrder(Order.desc(str));
			list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*8, 8);
		}else {
			DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
			criteria.add(Restrictions.eq("goodsType.id", Integer.parseInt(str)));
			list=(List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*8, 8);
		}
		return list;
	}

	public List<Goods> getAllByDate(Timestamp date2) {
		List<Goods> list = (List<Goods>) super.getHibernateTemplate().find("from Goods where creatTime >=? ", date2);
		return list;
	}

	public List<Goods> getAllByDate(int page, Timestamp date2) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		criteria.add(Restrictions.ge("creatTime", date2));
		List<Goods> list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*8, 8);
		return list;
	}

	public List<Goods> getAllByDataGrid(int page, int rows) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		List<Goods> list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}

	public List<Goods> queryGoods(String goodsname, String goodsfrom, String goodstypeid, String price1, String price2,
			String begindate, String lastdate) throws ParseException {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		if(goodsname != "") {
			criteria.add(Restrictions.like("name", "%"+goodsname+"%"));
		}
		if(goodsfrom != "") {
			criteria.add(Restrictions.like("goodFrom", "%"+goodsfrom+"%"));
		}
		if(goodstypeid != "") {
			criteria.add(Restrictions.eq("goodsType.id", Integer.parseInt(goodstypeid)));
		}
		if(price1 != "" && price2 != "") {
			criteria.add(Restrictions.between("nowPrice", Float.parseFloat(price1), Float.parseFloat(price2)));
		}
		if(begindate != "" && lastdate!="") {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			long time1 = dateFormat.parse(begindate).getTime();
			Timestamp timestamp1=new Timestamp(time1);
			long time2=dateFormat.parse(lastdate).getTime();
			Timestamp timestamp2=new Timestamp(time2);
			criteria.add(Restrictions.between("creatTime", timestamp1, timestamp2));
		}
		List<Goods> list = (List<Goods>) super.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	public List<Goods> queryGoodsByLimit(int page, int rows, String goodsname, String goodsfrom, String goodstypeid,
			String price1, String price2, String begindate, String lastdate) throws ParseException {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		if(goodsname != "") {
			criteria.add(Restrictions.like("name", "%"+goodsname+"%"));
		}
		if(goodsfrom != "") {
			criteria.add(Restrictions.like("goodFrom", "%"+goodsfrom+"%"));
		}
		if(goodstypeid != "") {
			criteria.add(Restrictions.eq("goodsType.id", Integer.parseInt(goodstypeid)));
		}
		if(price1 != "" && price2 != "") {
			criteria.add(Restrictions.between("nowPrice", Float.parseFloat(price1), Float.parseFloat(price2)));
		}
		if(begindate != "" && lastdate!="") {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			long time1 = dateFormat.parse(begindate).getTime();
			Timestamp timestamp1=new Timestamp(time1);
			long time2=dateFormat.parse(lastdate).getTime();
			Timestamp timestamp2=new Timestamp(time2);
			criteria.add(Restrictions.between("creatTime", timestamp1, timestamp2));
		}
		List<Goods> list=(List<Goods>) super.getHibernateTemplate().findByCriteria(criteria, (page-1)*rows, rows);
		return list;
	}
}
