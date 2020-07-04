package dao;

import java.util.ArrayList;
import java.util.List;

import model.FeedBackMessage;
import model.LivingMessage;
import util.JDBCUtil;

public class FeedBackDao {
	JDBCUtil jdbc=new JDBCUtil();
	
	public void insertFeedBack(FeedBackMessage fbm) {
		String sql="insert into feedback_info(username,feedback) values(?,?)";
		jdbc.updatePreparedStatement(sql,fbm.getUsername(),fbm.getFeedback());
	}
	
	public List<FeedBackMessage> queryFeedBack(String username) {
		String sql="select m.username,m.message,f.feedback\r\n" + 
				"from message_info m,feedback_info f\r\n" + 
				"where m.username=f.username ";
		ArrayList<Object> params = new ArrayList<Object>();
		if(username!=null && !username.equals("")){
			sql += "and username=?";
			params.add(username);
		}
		List<FeedBackMessage> fbm = jdbc.queryPreparedStatement(sql,FeedBackMessage.class, params);
		return fbm;
	} 
}
