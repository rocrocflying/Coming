/*
 * 此Java类用来处理用户登录逻辑业务
 * */
package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCl {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	public boolean queryUser(String userName,String passwd){
		boolean b=false;
		String sql="select PASSW from User_Info where USRNM='"+userName+"'";
		ConnDB cn=new ConnDB();
		ct=cn.getConn();
		try {
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				String passwd0=rs.getString(1);
				if(passwd0.equals(passwd));
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
	//通过用户名得到用户Id
	public int getUserIdByUserName(String userName){
		int userId=0;
		String sql="select USRID from User_Info where USRNM='"+userName+"'";
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
