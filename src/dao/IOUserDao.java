package dao;

import java.io.IOException;

import model.Register;

public interface IOUserDao {
	public abstract void regist(Register register) throws IOException;
	
	public abstract boolean login(String userName,String password);
}
