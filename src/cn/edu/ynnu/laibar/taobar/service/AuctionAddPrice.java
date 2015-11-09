package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuctionAddPrice {
	
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public boolean updateAuctiondetail(int auctionId,float qty){
		
		boolean b=false;
		String sql="update auction set currentprice=currentprice+'"+qty+"',increaseprice='"+qty+"',bidtimes=bidtimes+'"+1+"' where auctionId='"+auctionId+"'";
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
