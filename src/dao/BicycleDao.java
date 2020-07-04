package dao;

import java.util.List;
import java.util.ArrayList;

import model.Bicycle;
import util.JDBCUtil;

public class BicycleDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Bicycle> queryBicycle(String brand){
		String sql = "select * from bicycle_info where 1=1";
		ArrayList<Object> params = new ArrayList<Object>();
		if(brand!=null && !brand.equals("")){
			sql += " and brand=?";
			params.add(brand);
		}
		List<Bicycle> list = jdbc.queryPreparedStatement(sql,Bicycle.class, params);
		return list;
	} 
	
	public void updateBicycle(String lpn,String brand,String type,double price,String address) {
		String sql="update bicycle_info\r\n" + 
				"set brand=?,type=?,price=?,address=?\r\n" + 
				"where lpn=?";
		jdbc.updatePreparedStatement(sql, brand,type,price,address,lpn);
	}
	
}
