package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GoodsType implements Serializable{
	private Integer id;
	private String type;
	private Set<Goods> setGoods=new HashSet<Goods>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Goods> getSetGoods() {
		return setGoods;
	}
	public void setSetGoods(Set<Goods> setGoods) {
		this.setGoods = setGoods;
	}
}
