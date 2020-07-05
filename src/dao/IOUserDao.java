package dao;

import java.io.IOException;

import model.Register;

// TODO: Auto-generated Javadoc
/**
 * The Interface IOUserDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public interface IOUserDao {
	
	/**
	 * Regist.
	 *
	 * @param register the register
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public abstract void regist(Register register) throws IOException;
	
	/**
	 * Login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	public abstract boolean login(String userName,String password);
}
