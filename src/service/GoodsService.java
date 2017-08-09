package service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import entity.Goods;

public interface GoodsService {
	public List<Goods> getAll();
	
	public List<Goods> getByLimit(int page);
	
	public List<Goods> getAllBySale(String str);
	
	public List<Goods> getByLimitBySale(int page, String str);
	
	public Goods getOne(int goodsid);
	
	public List<Goods> getAllByDate(Timestamp date2);
	
	public List<Goods> getByLimitByDate(int page, Timestamp date2);
	
	public Serializable addOne(Goods goods);
	
	public List<Goods> getAllByDataGrid(int page, int rows);
	
	public void deleteOne(Goods goods);
	
	public void updateOne(Goods goods);
	
	public List<Goods> queryGoods(String goodsname, String goodsfrom, String goodstypeid, String price1, String price2,
			String begindate, String lastdate) throws ParseException;
	
	public List<Goods> queryGoodsByLimit(int page, int rows, String goodsname, String goodsfrom, String goodstypeid,
			String price1, String price2, String begindate, String lastdate) throws ParseException;
}
