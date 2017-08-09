package service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.GoodsDao;
import entity.Goods;

@Transactional
public class GoodsServiceImpl implements GoodsService{
	private GoodsDao goodsDao;
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public List<Goods> getAll() {
		return goodsDao.getAll();
	}
	public List<Goods> getByLimit(int page) {
		return goodsDao.getByLimit(page);
	}
	public List<Goods> getAllBySale(String str) {
		return goodsDao.getAllBySale(str);
	}
	public List<Goods> getByLimitBySale(int page, String str) {
		return goodsDao.getByLimitBySale(page,str);
	}
	public Goods getOne(int goodsid) {
		return goodsDao.getOne(goodsid);
	}
	public List<Goods> getAllByDate(Timestamp date2) {
		return goodsDao.getAllByDate(date2);
	}
	public List<Goods> getByLimitByDate(int page, Timestamp date2) {
		return goodsDao.getAllByDate(page,date2);
	}
	public Serializable addOne(Goods goods) {
		return goodsDao.add(goods);
	}
	public List<Goods> getAllByDataGrid(int page, int rows) {
		return goodsDao.getAllByDataGrid(page,rows);
	}
	public void deleteOne(Goods goods) {
		goodsDao.delete(goods);
	}
	public void updateOne(Goods goods) {
		goodsDao.update(goods);
	}
	public List<Goods> queryGoods(String goodsname, String goodsfrom, String goodstypeid, String price1, String price2,
			String begindate, String lastdate) throws ParseException {
		return goodsDao.queryGoods(goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
	}
	public List<Goods> queryGoodsByLimit(int page, int rows, String goodsname, String goodsfrom, String goodstypeid,
			String price1, String price2, String begindate, String lastdate) throws ParseException {
		return goodsDao.queryGoodsByLimit(page,rows,goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
	}
}
