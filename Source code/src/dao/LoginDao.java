package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import setting.DBConnection;

public class LoginDao {
	Connection conn = null;
	public ArrayList<HashMap<String,String>> getDataLogin() throws Exception{
		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		conn = DBConnection.getConnection("java:jboss/datasource/ds_bit");
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT NAMA_DEBITUR, CIS_NO AS NO_CIS "
				+ "FROM T_CUST "
				+ "FETCH FIRST 10 ROW ONLY";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap map = new HashMap();
				map.put("nama_debitur",rs.getString("nama_debitur"));
				map.put("no_cis",rs.getString("no_cis"));
				list.add(map);
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
		if (!list.isEmpty()) System.out.println("list = " + list.toString());
		
		return list;
	}
	
	public ArrayList<HashMap<String,String>> getDSData() throws Exception{
		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		conn = DBConnection.getConnection("java:/ds_ICOSSME");
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT REFF_NO "
				+ "FROM SME_APP "
				+ "FETCH FIRST ROW ONLY";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("get data success : " + rs.getString("REFF_NO"));
			}
			rs.close();
			ps.close();
		}finally{
			conn.close();
		}
		
		return list;
	}

}
