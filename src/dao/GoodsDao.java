package dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import entity.Goods;

public interface GoodsDao extends BaseDao<Goods> {

	public List<Goods> getByLimit(int page);
	
	public List<Goods> getAllBySale(String str);
	
	public List<Goods> getByLimitBySale(int page, String str);
	
	public List<Goods> getAllByDate(Timestamp date2);
	
	public List<Goods> getAllByDate(int page, Timestamp date2);
	
	public List<Goods> getAllByDataGrid(int page, int rows);
	
	public List<Goods> queryGoods(String goodsname, String goodsfrom, String goodstypeid, String price1, String price2,
			String begindate, String lastdate) throws ParseException;
	
	public List<Goods> queryGoodsByLimit(int page, int rows, String goodsname, String goodsfrom, String goodstypeid,
			String price1, String price2, String begindate, String lastdate) throws ParseException;
}
