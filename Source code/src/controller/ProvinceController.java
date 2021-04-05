package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ProvinceForm;
import service.ProvinceService;


public class ProvinceController extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageForward = "globalErrorPage";
		ProvinceService svc = new ProvinceService();	
		ProvinceForm frm = (ProvinceForm) form;
		String task = frm.getTask();

		HttpSession session = request.getSession();
		if("openList".equals(task)) {
			pageForward = "list";
			svc.getListProvince(frm);
		}
		else if ("openAdd".equals(task)) {
			pageForward = "edit";
			frm.setCode("");
			frm.setDsc("");
		}
		else if ("insertData".equals(task)) {
			pageForward = "list";
			//save data
			svc.insertProvince(frm);
			
			//get data
			svc.getListProvince(frm);
			
		}
		//frm.setTask("");
		return mapping.findForward(pageForward);
	}
}
