package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

public class MyOrderDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public List<Rental> queryMyOrder(String brand) {
		String sql="select b.lpn,b.brand,b.type,b.price,b.address,\r\n" + 
				"r.startdate,r.enddate,r.rentalnumber,r.username,r.telenumber\r\n" + 
				"from bicycle_info b,rental_info r\r\n" + 
				"where 1=1 and b.lpn=r.lpn ";
		ArrayList<Object> params = new ArrayList<Object>();
		if(brand!=null && !brand.equals("")){
			sql += "and b.brand=?";
			params.add(brand);
		}
		List<Rental> rental = jdbc.queryPreparedStatement(sql,Rental.class, params);
		return rental;
	}
	
	
	
}
