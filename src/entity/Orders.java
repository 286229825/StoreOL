package entity;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

public class Orders {
	private Integer id;
	private String address;
	private String phone;
	private float totalMoney;
	private String payMent;
	private Timestamp creatTime;
	private String postMethod;
	private String remarks;
	private Integer ifPost;
	private Customer customer;
	private Set<OrdersDetail> setOrdersDetail=new LinkedHashSet<OrdersDetail>();
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public Set<OrdersDetail> getSetOrdersDetail() {
		return setOrdersDetail;
	}
	public void setSetOrdersDetail(Set<OrdersDetail> setOrdersDetail) {
		this.setOrdersDetail = setOrdersDetail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getPayMent() {
		return payMent;
	}
	public void setPayMent(String payMent) {
		this.payMent = payMent;
	}
	public String getPostMethod() {
		return postMethod;
	}
	public void setPostMethod(String postMethod) {
		this.postMethod = postMethod;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getIfPost() {
		return ifPost;
	}
	public void setIfPost(Integer ifPost) {
		this.ifPost = ifPost;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
