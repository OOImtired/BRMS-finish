package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UserOrderDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class UserOrderDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Insert user order.
	 *
	 * @param rental the rental
	 */
	public void insertUserOrder(Rental rental) {
		String sql="insert into rental_info"
				+ "(lpn,brand,type,startDate,endDate,rentalNumber,username,teleNumber)"
				+ " values(?,?,?,?,?,?,?,?)";
		jdbc.updatePreparedStatement(sql,rental.getLpn(),rental.getBrand(),rental.getType(),
				rental.getStartdate(),rental.getEnddate(),rental.getRentalnumber(),
				rental.getUsername(),rental.getTelenumber());
	}
	
	/**
	 * Query user order.
	 *
	 * @return the list
	 */
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
