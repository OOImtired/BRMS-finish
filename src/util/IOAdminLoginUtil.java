package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dao.IOUserDao;
import model.Register;

public class IOAdminLoginUtil implements IOUserDao{
	public static File file=new File("E:\\各种PPT和Word\\Java课设\\管理员注册.txt");
	
	//静态代码块，随着类的加载而加载
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void regist(Register register) throws IOException {
		String info=register.getUsername()+" "+register.getPassword();
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\各种PPT和Word\\Java课设\\管理员注册.txt",true));
		bw.write(info);
		bw.newLine();
		bw.flush();
		bw.close();
	}

	@Override
	public boolean login(String userName, String password) {
		try {
			BufferedReader br=new BufferedReader(new FileReader("E:\\各种PPT和Word\\Java课设\\管理员注册.txt"));
			String line;
			while((line=br.readLine())!=null) {
				String[] s=line.split(" ");
				if(s[0].equals(userName)&&s[1].equals(password)) {
					return true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
