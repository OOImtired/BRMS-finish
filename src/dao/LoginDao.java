package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import model.User;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class LoginDao {

	/** The jdbc. */
	JDBCUtil jdbc = new JDBCUtil();
	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	public User login(String username,String password){
		String sql="select * from user_info where username=? and password=?";
		List<User> users = jdbc.queryPreparedStatement(sql, User.class,username,password);
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * IO login.
	 *
	 * @param br the br
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean IOLogin(BufferedReader br,String username,String password) throws Exception {
		String line;
		while((line=br.readLine())!=null) {
			String[] s=line.split(" ");
			if(s[0].equals(username)&&s[1].equals(password)) {
				return true;
			}
		}
		return false;
	}
	
}
