package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.ynnu.laibar.taobar.model.AuctionBean;
import cn.edu.ynnu.laibar.taobar.model.ConnectionDB;
import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.model.UserBean;
import cn.edu.ynnu.laibar.taobar.model.UserOrderBean;

public class UserAccountCL {
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/**
	 * 
	 * @param userId
	 * @return 通过userId查跳蚤市场发布商品
	 */
	public ArrayList<SaleGoodsBean> getGoodsReleaseDetail(int userId){
		ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
		String sql= "select * from Commodity_Info where USRID='"+userId+"'";
		ConnDB cn=new ConnDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				SaleGoodsBean sgb=new SaleGoodsBean();
				sgb.setGoodsid(rs.getInt(1));
				sgb.setImgpath(rs.getString(2));
				sgb.setGoodsdetail(rs.getString(3));
				sgb.setPrice(rs.getFloat(4));
				sgb.setCommodityName(rs.getString(5));
				sgb.setGoodssort(rs.getString(6));
				sgb.setQuantity(rs.getInt(7));
				sgb.setRelease_date(rs.getString(8));
				sgb.setPraiseNum(rs.getInt(9));
				sgb.setCommodityClass(rs.getString(10));
				System.out.println(sgb.getCommodityClass());
				sgb.setBrand(rs.getString(11));
				sgb.setReleaseState(rs.getString(12));
				sgb.setUserId(rs.getInt(13));
				
				al.add(sgb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	/**
	 * 
	 * @param goodsid
	 * @return 通过goodsid删除跳蚤市场发布商品
	 */
	public boolean deleteGoodsRelease(int goodsid){
		boolean b=false;
		String sql="delete from Commodity_Info where commodityId='"+goodsid+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	/**
	 * 
	 * @param userId
	 * @return 通过userId更新跳蚤市场发布商品
	 */
	public boolean updateGoodsRelease(String imgpath,String goodsdetail,float price,String commodityName,String commodityType,int quantity,
			String release_date, int praiseNum,String commodityClass,String brand, String  releaseState, int userId){
		boolean b=false;
		String sql="update Commodity_Info set imagePath='"+imgpath+"',commodityIntro='"+goodsdetail+
				"',price='"+price+"',commodityName='"+commodityName+"',commodityType='"+commodityType+
				"',quantity='"+quantity+"',release_date='"+release_date+"',praiseNum='"+praiseNum+
				"',commodityClass='"+commodityClass+"',brand='"+brand+"',releaseState='"+releaseState+
				"' where USRID='"+userId+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	/**
	 * 
	 * @param userId
	 * @return 通过userId查跳蚤市场订单
	 */
	public ArrayList<UserOrderBean> getGoodsOrderDetail(int userId){
		ArrayList<UserOrderBean> al=new ArrayList<UserOrderBean>();
		String sql= "select * from PurchaseOrder_Info where USRID='"+userId+"'";
		ConnDB cn=new ConnDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				UserOrderBean sgb=new UserOrderBean();
				sgb.setPurchaseOrderId(rs.getInt(1));
				sgb.setCommodityId(rs.getInt(2));
				sgb.setUserId(rs.getInt(3));
				sgb.setGoodsnum(rs.getInt(4));
				sgb.setOrder_date(rs.getString(5));
				sgb.setTotalprice(rs.getFloat(6));
				
				al.add(sgb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	
	/**
	 * 
	 * @param userId
	 * @return 通过userId查跳蚤市场订单
	 */
	public ArrayList<UserOrderBean> getGoodsOrderDetail2(int purchaseOrderId){
		ArrayList<UserOrderBean> al=new ArrayList<UserOrderBean>();
		String sql= "select * from PurchaseOrder_Info where purchaseOrderId='"+purchaseOrderId+"'";
		ConnDB cn=new ConnDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				UserOrderBean sgb=new UserOrderBean();
				sgb.setPurchaseOrderId(rs.getInt(1));
				sgb.setCommodityId(rs.getInt(2));
				sgb.setUserId(rs.getInt(3));
				sgb.setGoodsnum(rs.getInt(4));
				sgb.setOrder_date(rs.getString(5));
				sgb.setTotalprice(rs.getFloat(6));
				
				al.add(sgb);
				System.out.println("al333="+al);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	/**
	 * 
	 * @param userId
	 * @return 通过userId查跳蚤市场发布商品
	 */
	public boolean deleteGoodsOrder(int purchaseOrderId){
		boolean b=false;
		String sql="delete from PurchaseOrder_Info where purchaseOrderId='"+purchaseOrderId+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	
	/**
	 * 
	 * @param userid
	 * @return 通过userid查用户信息
	 */
	public ArrayList<UserBean> getUser(int userId) {
		// TODO Auto-generated method stub
		ArrayList<UserBean> al=new ArrayList<UserBean>();
		String sql= "select * from User_Info where USRID='"+userId+"'";
		ConnectionDB cn=new ConnectionDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				UserBean ab=new UserBean();
				ab.setUserId(rs.getInt(1));
				ab.setUserName(rs.getString(2));
				ab.setRealname(rs.getString(3));
				ab.setStudentId(rs.getString(4));
				ab.setPassword(rs.getString(5));
				ab.setSex(rs.getString(6));
				ab.setAge(rs.getInt(7));
				ab.setNation(rs.getString(8));
				ab.setAddress(rs.getString(9));
				ab.setQq(rs.getString(10));
				ab.setHead_pic(rs.getString(11));
				ab.setSchool(rs.getString(12));
				ab.setMajor(rs.getString(13));
				ab.setNativePlace(rs.getString(14));
				ab.setPhone(rs.getString(15));
				ab.setBrief(rs.getString(16));
				ab.setRegist_date(rs.getString(17));
				
				al.add(ab);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	
	/**
	 * 
	 * @param userid
	 * @return 通过userid查拍卖信息
	 */
	public ArrayList<AuctionBean> getAuctionDetail(int userId) {
		// TODO Auto-generated method stub
		ArrayList<AuctionBean> al=new ArrayList<AuctionBean>();
		String sql= "select * from auction where USRID='"+userId+"'";
		ConnectionDB cn=new ConnectionDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				AuctionBean ab=new AuctionBean();
				ab.setAuctionId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setType(rs.getString(3));
				ab.setPhotopath(rs.getString(4));
				ab.setDetail(rs.getString(5));
				ab.setStartprice(rs.getFloat(6));  
				ab.setCurrentprice(rs.getFloat(7));
				ab.setBidtimes(rs.getInt(8));
				ab.setStarttime(rs.getTimestamp(9));
				ab.setFinishtime(rs.getTimestamp(10));
				ab.setExpectprice(rs.getFloat(11));
				ab.setIncreaseprice(rs.getFloat(12));
				ab.setUSRID(rs.getInt(13));
				al.add(ab);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	} 
	/**
	 * 
	 * @param auctionId
	 * @return 通过auctionId查拍卖信息
	 */
	public ArrayList<AuctionBean> getAuctionDetail2(int auctionId) {
		// TODO Auto-generated method stub
		ArrayList<AuctionBean> al=new ArrayList<AuctionBean>();
		String sql= "select * from auction where auctionId='"+auctionId+"'";
		ConnectionDB cn=new ConnectionDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				AuctionBean ab=new AuctionBean();
				ab.setAuctionId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setType(rs.getString(3));
				ab.setPhotopath(rs.getString(4));
				ab.setDetail(rs.getString(5));
				ab.setStartprice(rs.getFloat(6));  
				ab.setCurrentprice(rs.getFloat(7));
				ab.setBidtimes(rs.getInt(8));
				ab.setStarttime(rs.getTimestamp(9));
				ab.setFinishtime(rs.getTimestamp(10));
				ab.setExpectprice(rs.getFloat(11));
				ab.setIncreaseprice(rs.getFloat(12));
				ab.setUSRID(rs.getInt(13));
				al.add(ab);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	} 
	public void close(){
		
		try {
			if(rs!=null){
			
				rs.close();
				rs=null;
			} 
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(ct!=null){
				ct.close();
				ct=null;
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	public boolean deleteAuction(int auctionId) {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="delete from auction where auctionId='"+auctionId+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	public boolean updateUser(String username, String studentId,
			String password, int age, String major, 
			String school,String nation, String realname, 
			String sex, String address, String phone, 
			String qq, String nativePlace, String brief,
		    String filename, int userid) {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="update User_Info set USRNM='"+username+"',STNUM='"+studentId+
				"',PASSW='"+password+"',AGE='"+age+"',MAJOR='"+major+
				"',SCHOOL='"+school+"',NSTIO='"+nation+"',RNAME='"+realname+
				"',SEX='"+sex+"',ADDRE='"+address+"',PHNUM='"+phone+
				"',QQ='"+qq+"',HOMET='"+nativePlace+"',BRIEF='"+brief+
				"',HEAD_PIC='"+filename+"' where USRID='"+userid+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	
	
	public boolean updateGoodsRelease(String filename, String goodsintro,
			float goodsprice, String goodsname, String goodssort, int goodsnum,
			String uptime, String class1, String brand, int userid) {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="update Commodity_Info set imagePath='"+filename+"',commodityIntro='"+goodsintro+
				"',price='"+goodsprice+"',commodityName='"+goodsname+"',commodityType='"+goodssort+
				"',quantity='"+goodsnum+"',release_date='"+uptime+"',commodityClass='"+class1+
				"',brand='"+brand+"' where USRID='"+userid+"'";
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		try {
			ps=ct.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
}
