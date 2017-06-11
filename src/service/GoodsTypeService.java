package service;

import java.util.List;

import dao.GoodsTypeDaoImpl;
import entity.GoodsType;

public class GoodsTypeService {
	private GoodsTypeDaoImpl goodsTypeDaoImpl;
	public void setGoodsTypeDaoImpl(GoodsTypeDaoImpl goodsTypeDaoImpl) {
		this.goodsTypeDaoImpl = goodsTypeDaoImpl;
	}
	public List<GoodsType> getAll() {
		return goodsTypeDaoImpl.getAll();
	}
}
