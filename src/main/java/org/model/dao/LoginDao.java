package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mis.ConnectionProvider;
import org.model.bean.UserBean;

public class LoginDao {

	public boolean login(UserBean bean) {
		// TODO Auto-generated method stub
		String email=bean.getEmail();
		String pass=bean.getPass();
		
		Connection con;
		PreparedStatement pstm;
		ResultSet rs;
		boolean status=false;
		try
		{
			con=ConnectionProvider.createC();
			pstm=con.prepareStatement("select * from users where email=? and pass=?");
			pstm.setString(1,email);
			pstm.setString(2,pass);
			rs=pstm.executeQuery();
			status=rs.next();
		}catch(Exception e) {
			System.out.print(e);
			
		}
		System.out.print(status);
		return status;
	}

	public int insert(UserBean ubean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
