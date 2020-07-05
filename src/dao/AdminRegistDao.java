package dao;

import model.Register;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminRegistDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class AdminRegistDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Insert admin register.
	 *
	 * @param register the register
	 */
	public void insertAdminRegister(Register register) {
		String sql="insert into admin_info values(?,?)";
		jdbc.updatePreparedStatement(sql,register.getUsername(),register.getPassword());
	}
}
