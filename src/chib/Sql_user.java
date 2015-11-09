package chib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Activity;
import entity.user;
import entity.user;

public class Sql_user {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private PreparedStatement ps2 = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public List<user> queryAll() {
		List<user> list = new ArrayList<user>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from User_Info";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				user p = new user();
                p.setUSRID(rs.getInt(1));
				p.setUSRNM(rs.getString(2));
				p.setSTNUM(rs.getString(4));
				p.setAGE(rs.getInt(7));
				p.setMAJOR(rs.getString(13));
				p.setSEX(rs.getString(6));
			    p.setADDRE(rs.getString(9));
			    p.setREG_DATE(rs.getString(17));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
	}
	
	public boolean queryuser(String username,String pwd) {
		boolean flag = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from User_Info where USRNM='"+username+"'and PASSW='"+pwd+"'" ;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flag;
		
		
      }
	public String queryid(String username,String pwd) {
		//boolean flag = false;
		String id="";
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from User_Info where USRNM='"+username+"'and PASSW='"+pwd+"'" ;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				id=String.valueOf(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		
		
		return id;				
      }
	public List<user> queryuser(String id) {
		   List<user> list = new ArrayList<user>();
		//String id="";
		user u=new user();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from User_Info where USRID='"+id+"' " ;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				u.setUSRNM(rs.getString(2));
				u.setSCHOL(rs.getString(12));
			    u.setMAJOR(rs.getString(13));
			    u.setSEX(rs.getString(6));
			    u.setREG_DATE(rs.getString(17));
			    list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}				
		return list;				
      }
	public boolean adduser(user u) throws Exception {
		boolean flag = false;
		try {
			
			conn = DBConn.getCon();
			conn.setAutoCommit(false);// 更改JDBC事务的默认提交方式
			
		    ps2 =conn.prepareCall("insert into User_Info(USRNM,RNAME,STNUM,PASSW,SEX,AGE,NSTIO,ADDRE,QQ,HEAD_PIC,SCHOOL,MAJOR,PHNUM,BRIEF,REG_DATE) " +
		    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps2.setString(1,u.getUSRNM() );
			ps2.setString(2, u.getRNAME());
			ps2.setString(3, u.getSTNUM());
			ps2.setString(4, u.getPASSW());
			ps2.setString(5, u.getSEX());
			ps2.setInt(6, u.getAGE());
			ps2.setString(7, u.getNSTIO());
			ps2.setString(8, u.getADDRE());
			
			ps2.setString(9, u.getQQ());
			ps2.setString(10, u.getHEAD_PIC());
			ps2.setString(11, u.getSCHOL());
			ps2.setString(12, u.getMAJOR());
			
			ps2.setString(13, u.getPHNUM());
			
			ps2.setString(14, u.getBRIEF());
			
			ps2.setString(15, u.getREG_DATE());
		    if(ps2.executeUpdate()>0)
			{
			  flag = true;
		    }
			
			
			 conn.commit();//提交JDBC事务
			 conn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flag;
		
	}
	
	
	
}
