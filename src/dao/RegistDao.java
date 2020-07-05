package dao;

import java.io.BufferedWriter;
import java.io.IOException;

import model.Register;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class RegistDao {
    
    /** The jdbc. */
    JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Insert register.
	 *
	 * @param register the register
	 */
	public void insertRegister(Register register) {
		String sql="insert into user_info values(?,?)";
		jdbc.updatePreparedStatement(sql,register.getUsername(),register.getPassword());
	}
	
	/**
	 * IO register.
	 *
	 * @param bw the bw
	 * @param register the register
	 * @throws Exception the exception
	 */
	public void IORegister(BufferedWriter bw,Register register) throws Exception {
		String info=register.getUsername()+" "+register.getPassword();
		bw.write(info);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
