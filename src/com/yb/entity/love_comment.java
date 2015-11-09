package com.yb.entity;

public class love_comment {
	
	private int id;
	private String usrid;
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	private int love_id;
	private String content;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getLove_id() {
		return love_id;
	}
	public void setLove_id(int love_id) {
		this.love_id = love_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
