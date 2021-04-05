package form;

import org.apache.struts.action.ActionForm;

public class HelloForm extends BaseForm {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
