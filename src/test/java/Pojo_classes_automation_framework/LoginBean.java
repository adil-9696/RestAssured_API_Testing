package Pojo_classes_automation_framework;

import com.opencsv.bean.CsvBindByName;


public class LoginBean {

	@CsvBindByName(column="username")
	private String username;
	
	@CsvBindByName(column="password")
	private String password;
	
	
	
	public LoginBean() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
