package dao;

import java.util.ArrayList;
import java.util.List;

import model.LivingMessage;
import util.JDBCUtil;

public class LivingMessageDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public void insertMessage(LivingMessage livingMessage) {
		String sql="insert into message_info(username,message) values(?,?)";
		jdbc.updatePreparedStatement(sql,livingMessage.getUsername(),livingMessage.getMessage());
	}
	
	public List<LivingMessage> queryMessage(String username) {
		String sql="select u.username,m.message\r\n" + 
				"from message_info m,user_info u\r\n" + 
				"where 1=1 and m.username=u.username ";
		ArrayList<Object> params = new ArrayList<Object>();
		if(username!=null && !username.equals("")){
			sql += "and username=?";
			params.add(username);
		}
		List<LivingMessage> lm = jdbc.queryPreparedStatement(sql,LivingMessage.class, params);
		return lm;
	}
}
