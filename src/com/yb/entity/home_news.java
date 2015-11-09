package com.yb.entity;

public class home_news {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getComent_count() {
		return coment_count;
	}
	public void setComent_count(int coment_count) {
		this.coment_count = coment_count;
	}
	private int province_id;
	private String userid;
	private String content;
	private int coment_count;

}
