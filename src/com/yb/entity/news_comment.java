package com.yb.entity;
public class news_comment {
	
	private int newsid;
	private int privinceid;
	private String usrid;
	private String content;
	private String state;
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public int getPrivinceid() {
		return privinceid;
	}
	public void setPrivinceid(int privinceid) {
		this.privinceid = privinceid;
	}
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
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
