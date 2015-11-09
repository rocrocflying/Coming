package cn.edu.ynnu.laibar.taobar.model;
/*对应数据库dbo.Commodity_Info表*/
public class SaleGoodsBean {

	private int goodsid;/*对应数据库commodityId字段*/
	private String imgpath;/*对应数据库imagePath字段*/
	private String goodsdetail;/*对应数据库commodityIntro字段*/
	private float price;/*对应数据库price字段*/
	/**/
	private String commodityName;
	private String goodssort;/*对应数据库commoditytype字段*/
	/*以下 对应数据库字段*/
	private int quantity;
	private String release_date;
	private int praiseNum;
	private String commodityClass;
	private String brand;
	private String releaseState;

	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getGoodsdetail() {
		return goodsdetail;
	}
	public void setGoodsdetail(String goodsdetail) {
		this.goodsdetail = goodsdetail;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getGoodssort() {
		return goodssort;
	}
	public void setGoodssort(String goodssort) {
		this.goodssort = goodssort;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	
	public String getReleaseState() {
		return releaseState;
	}
	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState;
	}
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public String getCommodityClass() {
		return commodityClass;
	}
	public void setCommodityClass(String commodityClass) {
		this.commodityClass = commodityClass;
	}
	
	
	
	
	
	
}
