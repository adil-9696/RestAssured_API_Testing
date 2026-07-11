package Pojo_classes_automation_framework;

public class logincred {

	private String username;
	private String password;
	
	public logincred(String username, String password) {
		this.username=username;
		this.password=password;
	}

	@Override
	public String toString() {
		return "logincred [username=" + username + ", password=" + password + "]";
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
