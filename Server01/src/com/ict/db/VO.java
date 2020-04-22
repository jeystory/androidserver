package com.ict.db;

public class VO {
	String idx, id, password, name, age, addr;
	public VO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public VO(String idx, String id, String password, String name, String age, String addr) {
		super();
		this.idx = idx;
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}



	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
