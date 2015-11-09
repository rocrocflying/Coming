package cn.edu.ynnu.laibar.taobar.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AuctionBeanBO {
	private ResultSet rs=null;
	private ResultSet rs2=null;
	private Connection ct=null;
	private PreparedStatement st=null;
	
	public ArrayList gettransportinfo(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='交通' and finishtime>'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}
	
	public ArrayList gettransportinfo2(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='交通' and finishtime<'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}					
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}
	

	public ArrayList getlifeinfo(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='生活' and finishtime>'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}
	
	public ArrayList getlifeinfo2(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='生活' and finishtime<'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}					
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}	
	
	
	
	
	public ArrayList getstudyinfo(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='学习' and finishtime>'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}
	
	public ArrayList getstudyinfo2(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='学习' and finishtime<'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}					
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}	
	
	
	public ArrayList getsportinfo(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='运动' and finishtime>'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}
	
	
	public ArrayList getsportinfo2(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='运动' and finishtime<'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}					
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}	
	
	public ArrayList getpostalinfo(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='通讯' and finishtime>'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}	
	
	
	public ArrayList getpostalinfo2(){     
		ArrayList al_1=new ArrayList();
		
		try {
			ct=new ConnectionDB().getConn();
			Date date=new Date();
			java.sql.Date currenttime=new java.sql.Date(date.getTime());
			st=ct.prepareStatement("select * from auction where type='通讯' and finishtime<'"+currenttime+"'");
			rs=st.executeQuery();		
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
				al_1.add(ab);
			}					
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al_1;
	}	
	
	public ArrayList getAuctionDetail(int ID){
		ArrayList al=new ArrayList();
		String sql= "select * from auction where auctionId='"+ID+"'";
		ConnectionDB cn=new ConnectionDB();
		ct=cn.getConn();
		try {
			st=ct.prepareStatement(sql);
			rs=st.executeQuery();
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
			if(st!=null){
				st.close();
				st=null;
			}
			if(ct != null && !ct.isClosed()){
				ct.close();
				ct=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	   }
	
	
}
