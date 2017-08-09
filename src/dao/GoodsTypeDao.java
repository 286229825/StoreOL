package dao;

import java.util.List;

import entity.GoodsType;

public interface GoodsTypeDao extends BaseDao<GoodsType>{
	public List<GoodsType> getAll();
}
