package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;

public class SaleGoodsCl {
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//salemainpage.jsp显示的信息
	/**
	 * @
	 * @return跳骚市场 主页的数据
	 */
	public  ArrayList<SaleGoodsBean> getSaleMainInfo(){                      
		ArrayList<SaleGoodsBean> al =new ArrayList<SaleGoodsBean>();
		String sql="select * from Commodity_Info where praiseNum >0";
		ConnDB cn=new ConnDB();
		
		try {
			ct=cn.getConn();
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
	 * @return 详情界面的商品信息
	 */
	public ArrayList<SaleGoodsBean> getGoodsDetail(int goodsid){
		ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
		String sql= "select * from Commodity_Info where commodityId='"+goodsid+"'";
		ConnDB cn=new ConnDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
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
	 * @return 得到分类为交通的商品  信息
	 */
	 public ArrayList<SaleGoodsBean> getTrafficInfo(){
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
			String sql= "select * from Commodity_Info where commodityType='交通'and praiseNum>0";
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
					
					sgb.setGoodssort(rs.getString(6));
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
		 * @return 得到分类为学习的商品信息
		 */
	 public ArrayList<SaleGoodsBean> getStudyInfo(){
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
			String sql= "select * from Commodity_Info where commodityType='学习' and praiseNum>0";
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
					
					sgb.setGoodssort(rs.getString(6));
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
		 * @return 得到分类为运动的商品信息
		 */
	 public ArrayList<SaleGoodsBean> getSportInfo(){
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
			String sql= "select * from Commodity_Info where commodityType='运动' and praiseNum>0";
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
					
					sgb.setGoodssort(rs.getString(6));
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
		 * @return 得到分类为其它的商品信息
		 */
	 public ArrayList<SaleGoodsBean> getOrthersInfo(){
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
			String sql= "select * from Commodity_Info where commodityType='其它' and praiseNum>0";
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
				
					sgb.setGoodssort(rs.getString(6));
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
	 * @param 用户名
	 * @此方法是通过用户名来得到买家的Id
	 * @return UserId
	 * */
	 public int getUserIdByUsername(String userName){
		 int userId=0;
		 String sql= "select USRID from User_Info where USRNM='"+userName+"'";
			ConnDB cn=new ConnDB();
			ct=cn.getConn();
			try {
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					userId=rs.getInt(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return userId;
	 }
	 //通过卖家ID得到卖家信息
	 public ArrayList<SaleGoodsBean> getUserInfoById(int userId){
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
		 String sql= "select * from User_Info where USRID='"+userId+"'";
			ConnDB cn=new ConnDB();
			ct=cn.getConn();
			try {
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					//userBean信息    。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
					
					
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
}
