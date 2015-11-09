package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PublishAuction {
	
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
//	public boolean insertPublishAuction(String name,String type,String photopath,String detail,float startprice,float currentprice,int bidtimes,Timestamp starttime,Timestamp finishtime,float expectprice,float increaseprice,int userId){
	public boolean insertPublishAuction(String name,String type,String photopath,String detail,float startprice,float currentprice,int bidtimes,float expectprice,float increaseprice,int userId){	
		boolean b=false;
		String sql="insert into auction(name,type,photopath,detail,startprice,currentprice,bidtimes,expectprice,increaseprice,USRID) values('"+name+"','"+type+"','"+photopath+"','"+detail+"','"+startprice+"'," +
				"'"+currentprice+"','"+bidtimes+"','"+expectprice+"','"+increaseprice+"','"+userId+"')";
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
