package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

public class UpdateOrderDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Rental> queryOrder(String brand) {
		String sql="select *\r\n" + 
				"from rental_info\r\n" + 
				"where 1=1 ";
		ArrayList<Object> params = new ArrayList<Object>();
		if(brand!=null && !brand.equals("")){
			sql += "and brand=?";
			params.add(brand);
		}
		List<Rental> rental = jdbc.queryPreparedStatement(sql,Rental.class, params);
		return rental;
	}
	
	public void updateUserOrder(String lpn,String brand,String type,
			Date startdate,Date enddate,int rentalNumber,String username,String teleNumber) {
		String sql="update rental_info\r\n" +
				"set brand=?,type=?,startdate=?,enddate=?,rentalnumber=?,username=?,telenumber=?\r\n" + 
				"where lpn=?";
		jdbc.updatePreparedStatement(sql, brand,type,startdate,enddate,rentalNumber,username,teleNumber,lpn);
	}
}
