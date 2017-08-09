package service;

import java.util.List;

import dao.GoodsTypeDao;
import entity.GoodsType;

public class GoodsTypeServiceImpl implements GoodsTypeService{
	private GoodsTypeDao goodsTypeDao;
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}
	public List<GoodsType> getAll() {
		return goodsTypeDao.getAll();
	}
}
