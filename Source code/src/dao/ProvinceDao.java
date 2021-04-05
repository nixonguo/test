package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import form.ProvinceForm;
import setting.DBConnection;

public class ProvinceDao {
	Connection conn = null;
	public ArrayList<ProvinceForm> getListProvince(ProvinceForm frm) throws Exception{
		ArrayList<ProvinceForm> list=new ArrayList<ProvinceForm>();
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT PROVINCE_ID, PROVINCE_NAME FROM BIT10_67965_M_PROVINCE WHERE "
				//+ frm.getSearchBy() + " = " + frm.getSearchValue();
				+ "UPPER(" + frm.getSearchBy() + ") LIKE UPPER('%' || ? || '%') ";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getSearchValue());
			rs = ps.executeQuery();
			while(rs.next()) {
				ProvinceForm resultFrm = new ProvinceForm();
				resultFrm.setCode(rs.getString("PROVINCE_ID"));
				resultFrm.setDsc(rs.getString("PROVINCE_NAME"));
				list.add(resultFrm);
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
		
		return list;
	}
	
	
	public void insertData(ProvinceForm frm) throws Exception{
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		String sql="INSERT INTO BIT10_67965_M_PROVINCE (PROVINCE_ID, PROVINCE_NAME) VALUES(?,?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getCode());
			ps.setString(2, frm.getDsc());
			ps.execute();
			
			ps.close();
		} finally{
			conn.close();
		}
	}
}
