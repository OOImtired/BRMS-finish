package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JDBCUtil {
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private static final String drivername = "com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/userregistry?user=root&password=12345otj&useSSL=true";
    
        
    public boolean MyConnectionDatabase()  {
        try {
            Class.forName(drivername);
            conn= DriverManager.getConnection(url);
            return  true;
        } catch (ClassNotFoundException e) {
            return  false;
        }
        catch (SQLException e) {
            return  false;
        }
    }
    
    
public void updatePreparedStatement(String sql,Object... params){
		MyConnectionDatabase();
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    

    public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,List<Object> params){
		MyConnectionDatabase();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.size();i++){
					pstm.setObject(i+1, params.get(i));
				}
			}
			
			rs = pstm.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			List<String> column = new ArrayList<String>();
			for(int i=0;i<count;i++){
				column.add(rsmd.getColumnName(i+1));
			}
			
			while(rs.next()){
				T obj = clazz.newInstance();
				
				for(int i=0;i<count;i++){
					String name = column.get(i).toLowerCase();
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					String type = f.getType().getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int val = rs.getInt(name);
						f.set(obj, val);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double val = rs.getDouble(name);
						f.set(obj, val);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float val = rs.getFloat(name);
						f.set(obj, val);
					}else if("java.lang.String".equals(type)){
						String val = rs.getString(name);
						f.set(obj, val);
					}else if("java.sql.Date".equals(type)){
						Date val = rs.getDate(name);
						f.set(obj, val);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}
					
				}
				
				result.add(obj);
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
    
    public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,Object...params){
		MyConnectionDatabase();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			rs = pstm.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取属性的数量
			int count = rsmd.getColumnCount();
			//获取属性的名字
			List<String> column = new ArrayList<String>();
			for(int i=0;i<count;i++){
				column.add(rsmd.getColumnName(i+1));
			}
			
			while(rs.next()){
				//创建对象
				T obj = clazz.newInstance();
				//获取结果集中每一列的名字
				for(int i=0;i<count;i++){
					String name = column.get(i).toLowerCase();
					//到类中找到与该name匹配的名字
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					//判断该属性的类型
					String type = f.getType().getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int val = rs.getInt(name);
						f.set(obj, val);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double val = rs.getDouble(name);
						f.set(obj, val);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float val = rs.getFloat(name);
						f.set(obj, val);
					}else if("java.lang.String".equals(type)){
						String val = rs.getString(name);
						f.set(obj, val);
					}else if("java.util.Date".equals(type)){
						Date val = rs.getDate(name);
						f.set(obj, val);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}
					
				}
				
				result.add(obj);
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
    
      
        
    public void close(){
		try {
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
