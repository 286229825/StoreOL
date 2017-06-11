package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Goods implements Serializable{
	private Integer id;
	private String name;
	private String goodFrom;
	private String introduce;
	private Timestamp creatTime;
	private float nowPrice;
	private float salePrice;
	private Integer buyTimes;
	private Integer ifSale;
	private String pictrue;
	public String getPictrue() {
		return pictrue;
	}
	public void setPictrue(String pictrue) {
		this.pictrue = pictrue;
	}
	private Set<OrdersDetail> setOrdersDetail=new HashSet<OrdersDetail>();
	private GoodsType goodsType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoodFrom() {
		return goodFrom;
	}
	public void setGoodFrom(String goodFrom) {
		this.goodFrom = goodFrom;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public float getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(float nowPrice) {
		this.nowPrice = nowPrice;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getBuyTimes() {
		return buyTimes;
	}
	public void setBuyTimes(Integer buyTimes) {
		this.buyTimes = buyTimes;
	}
	public Integer getIfSale() {
		return ifSale;
	}
	public void setIfSale(Integer ifSale) {
		this.ifSale = ifSale;
	}
	public Set<OrdersDetail> getSetOrdersDetail() {
		return setOrdersDetail;
	}
	public void setSetOrdersDetail(Set<OrdersDetail> setOrdersDetail) {
		this.setOrdersDetail = setOrdersDetail;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
}
