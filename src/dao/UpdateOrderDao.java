package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateOrderDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class UpdateOrderDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Query order.
	 *
	 * @param brand the brand
	 * @return the list
	 */
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
	
	/**
	 * Update user order.
	 *
	 * @param lpn the lpn
	 * @param brand the brand
	 * @param type the type
	 * @param startdate the startdate
	 * @param enddate the enddate
	 * @param rentalNumber the rental number
	 * @param username the username
	 * @param teleNumber the tele number
	 */
	public void updateUserOrder(String lpn,String brand,String type,
			Date startdate,Date enddate,int rentalNumber,String username,String teleNumber) {
		String sql="update rental_info\r\n" +
				"set brand=?,type=?,startdate=?,enddate=?,rentalnumber=?,username=?,telenumber=?\r\n" + 
				"where lpn=?";
		jdbc.updatePreparedStatement(sql, brand,type,startdate,enddate,rentalNumber,username,teleNumber,lpn);
	}
}
