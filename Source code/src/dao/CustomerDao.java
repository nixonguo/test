package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import setting.DBConnection;
import form.CustomerForm;

public class CustomerDao {
	Connection conn = null;
	public ArrayList<CustomerForm> getListCustomer() throws Exception{
		ArrayList<CustomerForm> list=new ArrayList<CustomerForm>();
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT ID, NAME, GENDER, ADDRESS FROM T_CUST_2";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
//				HashMap map = new HashMap();
//				map.put("ID",rs.getString("ID"));
//				map.put("NAME",rs.getString("NAME"));
//				map.put("GENDER",rs.getString("GENDER"));
//				map.put("ADDRESS",rs.getString("ADDRESS"));
				
				CustomerForm cust = new CustomerForm();
				cust.setId(rs.getString("ID"));
				cust.setName(rs.getString("NAME"));
				cust.setGender(rs.getString("GENDER"));
				cust.setAddress(rs.getString("ADDRESS"));
				list.add(cust);
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
		
		return list;
	}
	
	public void getDetailCustomer(CustomerForm frm) throws Exception{
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT ID, NAME, GENDER, ADDRESS, "
				+ "ID_TYPE, ID_NO, IS_DEACTIVATED "
				+ "FROM T_CUST_2 WHERE ID=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getId());
			rs = ps.executeQuery();
			if(rs.next()) {
				frm.setId(rs.getString("ID"));
				frm.setName(rs.getString("NAME"));
				frm.setGender(rs.getString("GENDER"));
				frm.setAddress(rs.getString("ADDRESS"));
				frm.setIdType(rs.getString("ID_TYPE"));
				frm.setIdNo(rs.getString("ID_NO"));
				frm.setIsDeactivated("1".equals(rs.getString("IS_DEACTIVATED"))?true:false);
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
	}
	
	public void insertCustomer(CustomerForm frm) throws Exception{
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		String sql="INSERT INTO T_CUST_2 VALUES(SYS_GUID(),?,?,?,?,?,?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getName());
			ps.setString(2, frm.getGender());
			ps.setString(3, frm.getAddress());
			ps.setString(4, frm.getIdType());
			ps.setString(5, frm.getIdNo());
			ps.setString(6, frm.isIsDeactivated()?"1":"0");
			ps.execute();
			
			ps.close();
		}finally{
			conn.close();
		}
	}
	
	public void updateCustomer(CustomerForm frm) throws Exception{
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		String sql="UPDATE T_CUST_2 SET NAME=?, GENDER=?, ADDRESS=?, " +
					"ID_TYPE=?, ID_NO=?, IS_DEACTIVATED=? WHERE ID=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getName());
			ps.setString(2, frm.getGender());
			ps.setString(3, frm.getAddress());
			ps.setString(4, frm.getIdType());
			ps.setString(5, frm.getIdNo());
			ps.setString(6, frm.isIsDeactivated()?"1":"0");
			ps.setString(7, frm.getId());
			ps.execute();
			
			ps.close();
		}finally{
			conn.close();
		}
	}
	
	public void deleteCustomer(CustomerForm frm) throws Exception{
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		String sql="DELETE FROM T_CUST_2 WHERE ID = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, frm.getId());
			ps.execute();
			
			ps.close();
		}finally{
			conn.close();
		}
	}
	
	public ArrayList<HashMap<String, String>> getCbIdType() throws Exception {
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		conn = DBConnection.getConnection(DBConnection.DS_BIT);
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT CODE, DSC FROM MT_BIT WHERE GROUP_ID=37 AND IS_DEACT='N'";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap<String,String> map = new HashMap<String,String>();
				map.put("key", rs.getString("CODE"));
				map.put("value", rs.getString("DSC"));
				list.add(map);
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
		
		return list;
	}
}
