package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.mis.ConnectionProvider;
import org.model.bean.UserBean;

public class ForgetPassDao {

	public int insert(UserBean ubean) {
		// TODO Auto-generated method stub
		String email=ubean.getEmail();
		String newpass=ubean.getNewPass();
		Connection con;
		Statement st;
		PreparedStatement pstm;
		ResultSet rs;
		int i=0;
		try
		{
			con=ConnectionProvider.createC();
			st=con.createStatement();
			rs=st.executeQuery("select * from users where email='"+email+"'");
			while(rs.next()) {
			pstm=con.prepareStatement("update users set pass='"+newpass+"' where email='"+email+"'");
			i=pstm.executeUpdate();
			}
			if(i==0) {
				return i;
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		return i;
	}

}
