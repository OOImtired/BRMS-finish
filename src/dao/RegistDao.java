package dao;

import java.io.BufferedWriter;
import java.io.IOException;

import model.Register;
import util.JDBCUtil;

public class RegistDao {
    JDBCUtil jdbc=new JDBCUtil();
	
	public void insertRegister(Register register) {
		String sql="insert into user_info values(?,?)";
		jdbc.updatePreparedStatement(sql,register.getUsername(),register.getPassword());
	}
	
	public void IORegister(BufferedWriter bw,Register register) throws Exception {
		String info=register.getUsername()+" "+register.getPassword();
		bw.write(info);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
