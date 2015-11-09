//此方法用来对用户完成订单处理
package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.ynnu.laibar.taobar.model.UserBean;

public class SaleOrderCl {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/*
	 * 此方法为想订单表插入订单   并且相应的减掉商品表 中的数量
	 * */
	public boolean insertGoodsOrder(int commodityId, int userId,int goodsnum ,String order_date,float totalprice){
		boolean b=false;
		String sql="insert into PurchaseOrder_Info values('"+commodityId+"','"+userId+"','"+goodsnum+"','"+order_date+"','"+totalprice+"')";
		ConnDB cd=new ConnDB();
		
		try {
			ct=cd.getConn();
			ps=ct.prepareStatement(sql);
			int a=ps.executeUpdate();
			if(a==1){            
				ps=ct.prepareStatement("update Commodity_Info set praiseNum=(praiseNum-"+goodsnum+") where commodityId="+commodityId+"");
				int i=ps.executeUpdate();
				if(i==1){
					b=true;
				}
			}
			else{
				b=false;
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
	 * @此方法是通过商品Id得到卖家的用户信息
	 * @return UserBean
	 * @param goodsId
	 * */
	public UserBean getUserInfoByCommodityId(int commodityId){
		UserBean ub=new UserBean();
		String sql="select * from User_Info where USRID=(select USRID from Commodity_Info where commodityId="+commodityId+")";
		ConnDB cd=new ConnDB();
		
		try {
			ct=cd.getConn();
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){            
				ub.setAddress(rs.getString(12));
				ub.setPhone(rs.getString(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return ub;
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
