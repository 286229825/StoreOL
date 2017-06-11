package service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.GoodsDaoImpl;
import entity.Goods;

@Transactional
public class GoodsService {
	private GoodsDaoImpl goodsDaoImpl;
	public void setGoodsDaoImpl(GoodsDaoImpl goodsDaoImpl) {
		this.goodsDaoImpl = goodsDaoImpl;
	}
	public List<Goods> getAll() {
		return goodsDaoImpl.getAll();
	}
	public List<Goods> getByLimit(int page) {
		return goodsDaoImpl.getByLimit(page);
	}
	public List<Goods> getAllBySale(String str) {
		return goodsDaoImpl.getAllBySale(str);
	}
	public List<Goods> getByLimitBySale(int page, String str) {
		return goodsDaoImpl.getByLimitBySale(page,str);
	}
	public Goods getOne(int goodsid) {
		return goodsDaoImpl.getOne(goodsid);
	}
	public List<Goods> getAllByDate(Timestamp date2) {
		return goodsDaoImpl.getAllByDate(date2);
	}
	public List<Goods> getByLimitByDate(int page, Timestamp date2) {
		return goodsDaoImpl.getAllByDate(page,date2);
	}
	public Serializable addOne(Goods goods) {
		return goodsDaoImpl.add(goods);
	}
	public List<Goods> getAllByDataGrid(int page, int rows) {
		return goodsDaoImpl.getAllByDataGrid(page,rows);
	}
	public void deleteOne(Goods goods) {
		goodsDaoImpl.delete(goods);
	}
	public void updateOne(Goods goods) {
		goodsDaoImpl.update(goods);
	}
	public List<Goods> queryGoods(String goodsname, String goodsfrom, String goodstypeid, String price1, String price2,
			String begindate, String lastdate) throws ParseException {
		return goodsDaoImpl.queryGoods(goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
	}
	public List<Goods> queryGoodsByLimit(int page, int rows, String goodsname, String goodsfrom, String goodstypeid,
			String price1, String price2, String begindate, String lastdate) throws ParseException {
		return goodsDaoImpl.queryGoodsByLimit(page,rows,goodsname,goodsfrom,goodstypeid,price1,price2,begindate,lastdate);
	}
}
