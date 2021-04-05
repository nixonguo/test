package form;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginForm extends BaseForm {
	private String username;
	private String password;
	private ArrayList<HashMap<String,String>> listData;
	
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
	public ArrayList<HashMap<String, String>> getListData() {
		return listData;
	}
	public void setListData(ArrayList<HashMap<String, String>> listData) {
		this.listData = listData;
	}
	
}
