package dao;

import model.Register;
import util.JDBCUtil;

public class AdminRegistDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public void insertAdminRegister(Register register) {
		String sql="insert into admin_info values(?,?)";
		jdbc.updatePreparedStatement(sql,register.getUsername(),register.getPassword());
	}
}
