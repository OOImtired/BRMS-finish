package dao;

import java.util.List;

import model.Admin;
import util.JDBCUtil;

public class AdminLoginDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public Admin adminLogin(String adminname,String adminpassword) {
		String sql="select * from admin_info where adminname=? and adminpassword=?";
		List<Admin> admins=jdbc.queryPreparedStatement(sql, Admin.class,adminname,adminpassword);
		if(admins!=null && admins.size()>0){
			return admins.get(0);
		}
		return null;
	}
}
