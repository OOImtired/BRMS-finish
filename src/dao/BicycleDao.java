package dao;

import java.util.List;
import java.util.ArrayList;

import model.Bicycle;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class BicycleDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class BicycleDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Query bicycle.
	 *
	 * @param brand the brand
	 * @return the list
	 */
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
	
	/**
	 * Update bicycle.
	 *
	 * @param lpn the lpn
	 * @param brand the brand
	 * @param type the type
	 * @param price the price
	 * @param address the address
	 */
	public void updateBicycle(String lpn,String brand,String type,double price,String address) {
		String sql="update bicycle_info\r\n" + 
				"set brand=?,type=?,price=?,address=?\r\n" + 
				"where lpn=?";
		jdbc.updatePreparedStatement(sql, brand,type,price,address,lpn);
	}
	
}
