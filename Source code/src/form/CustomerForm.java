package form;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerForm extends LoginForm {
	private String id;
	private String name;
	private String gender;
	private String address;
	private String idType;
	private String idNo;
	private String message;
	private boolean isDeactivated = false;

	private ArrayList<CustomerForm> listCustomer;
	private ArrayList<HashMap<String,String>> cbIdType;
//	private ArrayList<HashMap<String,String>> listCustomer;

	public String getId() {
		return id;
	}

	public ArrayList<HashMap<String, String>> getCbIdType() {
		return cbIdType;
	}

	public void setCbIdType(ArrayList<HashMap<String, String>> cbIdType) {
		this.cbIdType = cbIdType;
	}

	public boolean isIsDeactivated() {
		return isDeactivated;
	}

	public void setIsDeactivated(boolean isDeactivated) {
		this.isDeactivated = isDeactivated;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public ArrayList<CustomerForm> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(ArrayList<CustomerForm> listCustomer) {
		this.listCustomer = listCustomer;
	}
}
