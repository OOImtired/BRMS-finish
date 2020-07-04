package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import model.User;
import util.JDBCUtil;

public class LoginDao {

	JDBCUtil jdbc = new JDBCUtil();
	
	public User login(String username,String password){
		String sql="select * from user_info where username=? and password=?";
		List<User> users = jdbc.queryPreparedStatement(sql, User.class,username,password);
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
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
