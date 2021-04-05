package form;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm {
	private String task;
	private String actMsg;
	private String errMsg;

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getActMsg() {
		return actMsg;
	}

	public void setActMsg(String actMsg) {
		this.actMsg = actMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
