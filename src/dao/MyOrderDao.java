package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Rental;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MyOrderDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class MyOrderDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Query my order.
	 *
	 * @param brand the brand
	 * @return the list
	 */
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
