package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

public class UserOrderDao {
	JDBCUtil jdbc=new JDBCUtil();
	public void insertUserOrder(Rental rental) {
		String sql="insert into rental_info"
				+ "(lpn,brand,type,startDate,endDate,rentalNumber,username,teleNumber)"
				+ " values(?,?,?,?,?,?,?,?)";
		jdbc.updatePreparedStatement(sql,rental.getLpn(),rental.getBrand(),rental.getType(),
				rental.getStartdate(),rental.getEnddate(),rental.getRentalnumber(),
				rental.getUsername(),rental.getTelenumber());
	}
	public List<Rental> queryUserOrder() {
		String sql="select b.lpn,b.brand,b.type,b.price,b.address,\r\n" + 
				"				r.startdate,r.enddate,r.rentalnumber,r.username,r.telenumber\r\n" + 
				"				from bicycle_info b,rental_info r,user_info u\r\n" + 
				"				where 1=1 and b.lpn=r.lpn and r.username=u.username";
		ArrayList<Object> params = new ArrayList<Object>();
		List<Rental> rental = jdbc.queryPreparedStatement(sql,Rental.class, params);
		return rental;
	}
	
}
