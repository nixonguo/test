package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.CustomerDao;
import form.CustomerForm;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	public void getListCustomer(CustomerForm frm) {
		ArrayList<CustomerForm> listCustomer = new ArrayList<CustomerForm>();
		try {
			listCustomer = customerDao.getListCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		frm.setListCustomer(listCustomer);
	}
	
	public void getDetailCustomer(CustomerForm frm) {
		try {
			customerDao.getDetailCustomer(frm);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertCustomer(CustomerForm frm) {
		try {
			customerDao.insertCustomer(frm);
			frm.setMessage("Data Inserted");
		} catch(Exception e) {
			e.printStackTrace();
			frm.setMessage("Failed");
		}
	}
	
	public void updateCustomer(CustomerForm frm) {
		try {
			customerDao.updateCustomer(frm);
			frm.setMessage("Data Updated");
		} catch(Exception e) {
			e.printStackTrace();
			frm.setMessage("Failed");
		}
	}
	
	public void deleteCustomer(CustomerForm frm) {
		try {
			customerDao.deleteCustomer(frm);
			frm.setMessage("Data Deleted");
		} catch(Exception e) {
			e.printStackTrace();
			frm.setMessage("Failed");
		}
	}
	
	public ArrayList<HashMap<String, String>> getCbIdType() {
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		try {
			list = customerDao.getCbIdType();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
