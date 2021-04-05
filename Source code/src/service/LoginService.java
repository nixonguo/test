package service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import bca.util.common.CommonLog;
import dao.LoginDao;
import form.LoginForm;

public class LoginService {
	LoginDao loginDao = new LoginDao();
	
	public static final Logger BATCH_APPICOS_LOGGER = CommonLog.getLogger(
			"LOG_TEST",
			"%d (%C{1}:%M:%L) - %m%n",
			"%d (%C{1}:%M:%L) - %m%n",
			"N",
			"/output/logs/test.log", //mounting folder
			"5MB",
			10,
			"ALL");

	private static Logger bLog = BATCH_APPICOS_LOGGER;
	
	public String doLogin(LoginForm frm, HttpSession session) {
		//test logging
		bLog.info("================= This is to test the validity of the log");
		
		
		String pageForward = "login";
		//check valid login
		if (isValidLogin(frm)) {
			System.out.println("LOGIN IS VALID !");
			//set session
			session.setAttribute("username", frm.getUsername());
			
			ArrayList<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
			try {
				//get homepage data
				//listData = loginDao.getDataLogin();
				
				
				//test OCP only
				listData = loginDao.getDSData();
				
				pageForward = "home";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			frm.setListData(listData);
		}
		else {
			frm.setErrMsg("Invalid User id / Password");
		}
		
		return pageForward;
		
	}
	
	public boolean isValidLogin(LoginForm frm) {
		boolean isValid = false;
		
		if ("NXN".equals(frm.getUsername())) {
			isValid = true;
		}
		
		return isValid;
	}
	
}
