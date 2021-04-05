package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.CustomerService;
import form.CustomerForm;

public class CustomerController extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageForward = "list";
		CustomerService customerService = new CustomerService();	
		CustomerForm frm = (CustomerForm) form;
		String task = frm.getTask();

		HttpSession session = request.getSession();
		frm.setUsername((String)session.getAttribute("username"));
		frm.setMessage("");
		System.out.println(frm.getName());
		if("list".equals(task)) {
			pageForward = "list";
			customerService.getListCustomer(frm);
		}
		else if("add".equals(task)) {
			frm.setName("");
			frm.setGender("");
			frm.setAddress("");
			frm.setIdType("");
			frm.setId("");
			frm.setIdNo("");
			frm.setIsDeactivated(false);
//			request.setAttribute("cbIdType", customerService.getCbIdType());
			frm.setCbIdType(customerService.getCbIdType());
			pageForward = "edit";
		}
		else if("edit".equals(task)) {
			pageForward = "edit";
			customerService.getDetailCustomer(frm);
//			request.setAttribute("cbIdType", customerService.getCbIdType());
			frm.setCbIdType(customerService.getCbIdType());
		}
		else if("addPage1".equals(task)) {
			pageForward = "edit";
			request.setAttribute("cbIdType", customerService.getCbIdType());
		}
		else if("editPage1".equals(task)) {
			pageForward = "edit";
			request.setAttribute("cbIdType", customerService.getCbIdType());
		}
		else if("addPage2".equals(task)) {
			pageForward = "edit2";
			request.setAttribute("cbIdType", customerService.getCbIdType());
		}
		else if("editPage2".equals(task)) {
			pageForward = "edit2";
			request.setAttribute("cbIdType", customerService.getCbIdType());
		}
		else if("insert".equals(task)) {
			pageForward = "list";
			customerService.insertCustomer(frm);
			customerService.getListCustomer(frm);
			frm.setTask("list");
		}
		else if("update".equals(task)) {
			pageForward = "list";
			customerService.updateCustomer(frm);
			customerService.getListCustomer(frm);
			frm.setTask("list");
		}
		else if("delete".equals(task)) {
			pageForward = "list";
			customerService.deleteCustomer(frm);
			customerService.getListCustomer(frm);
			frm.setTask("list");
		}
		else if("tes".equals(task)) {
			pageForward = "tes";
		}
		else {
			pageForward = "list";
			customerService.getListCustomer(frm);
		}
		return mapping.findForward(pageForward);
	}
}
