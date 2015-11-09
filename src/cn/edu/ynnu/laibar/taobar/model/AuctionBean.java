package cn.edu.ynnu.laibar.taobar.model;

import java.sql.Timestamp;

public class AuctionBean {
	private int auctionId;
	private String name;
	private String type;
	private String photopath;
	private String detail;
	private float startprice;
	private float currentprice;
	private int bidtimes;
	private Timestamp starttime;
	private Timestamp finishtime;
	private float increaseprice;
	private float expectprice;
	private int USRID;
	
	
	public float getIncreaseprice() {
		return increaseprice;
	}
	public void setIncreaseprice(float increaseprice) {
		this.increaseprice = increaseprice;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public float getStartprice() {
		return startprice;
	}
	public void setStartprice(float startprice) {
		this.startprice = startprice;
	}
	public float getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(float currentprice) {
		this.currentprice = currentprice;
	}
	public int getBidtimes() {
		return bidtimes;
	}
	public void setBidtimes(int bidtimes) {
		this.bidtimes = bidtimes;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Timestamp finishtime) {
		this.finishtime = finishtime;
	}
	public float getExpectprice() {
		return expectprice;
	}
	public void setExpectprice(float expectprice) {
		this.expectprice = expectprice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUSRID() {
		return USRID;
	}
	public void setUSRID(int uSRID) {
		USRID = uSRID;
	}

}
