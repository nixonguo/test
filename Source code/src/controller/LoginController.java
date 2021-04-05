package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.LoginService;
import setting.ICosPropsReader;
import setting.PropsReader;
import form.LoginForm;

public class LoginController extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageForward = "login";
		LoginService loginService = new LoginService();	
		LoginForm frm = (LoginForm) form;
		String task = frm.getTask();

		HttpSession session = request.getSession();
		session.setAttribute("username", frm.getUsername());
		
		System.out.println("task = " + task);
		System.out.println("username = " + frm.getUsername());
		
		//read properties section
		System.out.println("********** READ PROPERTIES *******************");
		System.out.println(PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.1"));
		System.out.println(PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.2"));
		System.out.println(PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.3"));
		
		//test icos properties reading
		ICosPropsReader.initAppConfig();
		
		if("home".equals(task)) {
			pageForward = loginService.doLogin(frm, session);
		}
		return mapping.findForward(pageForward);
	}
}
