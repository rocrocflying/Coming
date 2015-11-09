package com.yb.sql;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yb.entity.Activity;
import com.yb.entity.User;
import com.yb.entity.UserInfo;
import com.yb.sql.DBConn;




public class UserSql {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	public boolean addUser(User user) {
		boolean flg = false;
		try {
			conn =DBConn.getCon();
			ps = conn.prepareStatement("insert into user_info values ( ? ,? ,? ,? ,? ,?,?,?,?,?,?,?,?,?,?,?)");
		
			//ps.setString(1,user.getSch().substring((user.getSch().length()-6))+user.getStuid());//����ѧУ����+ѧ��
			ps.setString(1,user.getName());
			ps.setString(2,user.getRname());
			ps.setString(3,user.getStuid());
			ps.setString(4,user.getPwd());
			ps.setString(5,user.getSex());
			ps.setString(6,user.getAge());
			ps.setString(7,user.getNation());
			ps.setString(8, user.getHome());
			ps.setString(9,user.getQq());
			ps.setString(10, user.getTx_pix());
			ps.setString(11,user.getSch());
			ps.setString(12,user.getMajor());
			ps.setString(13, user.getPrivince());
			ps.setString(14,user.getPhnum());
			//ps.setString(16, user.getIdcard());
			ps.setString(15, user.getBrief());
			//ps.setInt(18,user.getPoint());
			//ps.setInt(19,0);
			ps.setString(16,TimeFactory.getTime());
			
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flg;
		
	}
	
	public boolean queryUser(String uname,String psw)
	{
		boolean k=false;
	 try
	 {
		 conn=DBConn.getCon();
		 ps=conn.prepareStatement("select * from user_info where USRNM=? and passw=?");
		 ps.setString(1,uname);
		 ps.setString(2,psw);
		 
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 k=true;
		 }
	
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
	}
//	public List<Activity> queryAllProduct() {
//		List<Activity> list = new ArrayList<Activity>();
//		try {
//			conn = DBConn.getCon();
//			stmt = conn.createStatement();
//			String sql = "select * from Activity_Info where ACT_STATE= 0";
//			
//			rs = stmt.executeQuery(sql);
//			while (rs.next()){
//				Activity p = new Activity();
//
//				p.setAct_image(rs.getString(16));
//				p.setAct_title(rs.getString(3));
//			    p.setAct_state(rs.getInt(17));
//				p.setAct_count(rs.getInt(6));
//				p.setAct_place(rs.getString(4));
//				
//				
//				list.add(p);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DBConn.closeAll(conn, stmt, rs);
//		}
//		return list;
//	}
	
	
	public User queryPersonByid(int id) {
		 User u=new User();
		try {
			conn =DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from User_Info where USRID="+id;
        
          rs = stmt.executeQuery(sql);
			while (rs.next()){
				u.setUsrid(rs.getInt("usrid"));
				u.setTx_pix(rs.getString("head_pic"));
				u.setHome(rs.getString("homet"));
				u.setSex(rs.getString("sex"));
			    u.setName(rs.getString("usrnm"));
			   // u.setPoint(rs2.getInt("point"));
             
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return u;
	}
	
	public User queryPerson(String uname,String psw) {
		 User u=new User();
		try {
			conn =DBConn.getCon();
            ps=conn.prepareStatement("select * from user_info where USRNM=? and passw=?");
            ps.setString(1,uname);
   		    ps.setString(2,psw);
			ResultSet rs2 = ps.executeQuery();
			while (rs2.next()){
				u.setUsrid(rs2.getInt("usrid"));
				u.setTx_pix(rs2.getString("head_pic"));
				u.setHome(rs2.getString("homet"));
				u.setSex(rs2.getString("sex"));
			    u.setName(rs2.getString("usrnm"));
			   // u.setPoint(rs2.getInt("point"));
               
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return u;
	}
	
	
	
	
	public UserInfo queryUserInfoBypId(int id) {
		UserInfo p = null;
		try {
			conn=DBConn.getCon(); 
			stmt = conn.createStatement();
			String sql = "select * from User_Info where USRID="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				 p = new UserInfo();

				 p.setUsrid(rs.getInt(1));
				 p.setUsrnm(rs.getString(2));
				 p.setRname(rs.getString(3));
				 p.setStnum(rs.getString(4));
				 p.setPassw(rs.getString(5));
				 p.setSex(rs.getString(6));
				 p.setAge(rs.getInt(7));
				 p.setNstio(rs.getString(8));
				 p.setAddre(rs.getString(9));
			 	 p.setQq(rs.getString(10));
			 	 p.setHead_pic(rs.getString(11));
			 	 p.setSchol(rs.getString(12));
			 	 p.setMajor(rs.getString(13));	
				
			 	 p.setHomet(rs.getString(14));
			 	 p.setPhnum(rs.getString(15));
				
				
				// p.setIdnum(rs.getString(17));
				
				 p.setBrief(rs.getString(16));
			  
				// p.setPoint(rs.getInt(19));
				
				// p.setIfost(rs.getString(17));
				
			
				 p.setReg_date(rs.getString(17));
				  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
	}
}
