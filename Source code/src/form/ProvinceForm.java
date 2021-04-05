package form;

import java.util.ArrayList;

/**
 * @author u051104
 *
 */
public class ProvinceForm extends BaseForm {
	private String searchBy;
	private String searchValue;
	
	private String code;
	private String dsc;
	private ArrayList<ProvinceForm> listProvince;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public ArrayList<ProvinceForm> getListProvince() {
		return listProvince;
	}
	public void setListProvince(ArrayList<ProvinceForm> listProvince) {
		this.listProvince = listProvince;
	}
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
}
