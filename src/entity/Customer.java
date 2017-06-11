package entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer id;
	private String name;
	private String password;
	private String realName;
	private Date birthday;
	private String vocation;
	private String email;
	private String sex;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private Set<Orders> setOrders=new HashSet<Orders>();
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Orders> getSetOrders() {
		return setOrders;
	}
	public void setSetOrders(Set<Orders> setOrders) {
		this.setOrders = setOrders;
	}
}
