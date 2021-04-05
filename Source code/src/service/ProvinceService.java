package service;

import java.util.ArrayList;

import dao.ProvinceDao;
import form.ProvinceForm;


public class ProvinceService {
	ProvinceDao dao = new ProvinceDao();
	public void getListProvince(ProvinceForm frm) {
		ArrayList<ProvinceForm> listProvince = new ArrayList<ProvinceForm>();
		try {
			listProvince = dao.getListProvince(frm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		frm.setListProvince(listProvince);
	}
	
	public void insertProvince(ProvinceForm frm) {
		try {
			dao.insertData(frm);
			frm.setActMsg("Data Inserted");
		} catch(Exception e) {
			e.printStackTrace();
			frm.setErrMsg("Failed");
		}
	}
}
