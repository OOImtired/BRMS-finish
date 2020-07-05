package dao;

import java.util.List;

import model.Admin;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminLoginDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class AdminLoginDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Admin login.
	 *
	 * @param adminname the adminname
	 * @param adminpassword the adminpassword
	 * @return the admin
	 */
	public Admin adminLogin(String adminname,String adminpassword) {
		String sql="select * from admin_info where adminname=? and adminpassword=?";
		List<Admin> admins=jdbc.queryPreparedStatement(sql, Admin.class,adminname,adminpassword);
		if(admins!=null && admins.size()>0){
			return admins.get(0);
		}
		return null;
	}
}
