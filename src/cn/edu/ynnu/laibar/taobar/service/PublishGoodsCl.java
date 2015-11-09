package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublishGoodsCl {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/**
	 * @return boolean
	 * @ 此方法用来 实现用户发布商品 的信息插入到数据库
	 * @param 变量每个字段都与数据库的字段相同 
	 */
	public boolean insertPublishGoods(String imgpath,String goodsdetail,float price,String commodityName,String commodityType,int quantity,
			String release_date, int praiseNum,String commodityClass,String brand, String  releaseState, int userId){
		
		boolean b=false;
		String sql="insert into Commodity_Info values('"+imgpath+"','"+goodsdetail+"','"+price+"','"+commodityName+"','"+commodityType+"'," +
				"'"+quantity+"','"+release_date+"','"+praiseNum+"','"+commodityClass+"','"+brand+"','"+releaseState+"','"+userId+"')";
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
