package dao;

import java.util.ArrayList;
import java.util.List;

import model.FeedBackMessage;
import model.LivingMessage;
import util.JDBCUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedBackDao.
 *
 * @author OOImtired
 * @version v1.0
 * @date 2020年7月5日
 */
public class FeedBackDao {
	
	/** The jdbc. */
	JDBCUtil jdbc=new JDBCUtil();
	
	/**
	 * Insert feed back.
	 *
	 * @param fbm the fbm
	 */
	public void insertFeedBack(FeedBackMessage fbm) {
		String sql="insert into feedback_info(username,feedback) values(?,?)";
		jdbc.updatePreparedStatement(sql,fbm.getUsername(),fbm.getFeedback());
	}
	
	/**
	 * Query feed back.
	 *
	 * @param username the username
	 * @return the list
	 */
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
