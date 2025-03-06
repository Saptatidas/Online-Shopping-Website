package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mis.ConnectionProvider;
import org.model.bean.UserBean;

public class SignupDao {

	public int insert(UserBean bean) {
		// TODO Auto-generated method stub
		
		String name=bean.getName();
		String email=bean.getEmail();
		String phno=bean.getPhno();
		String pass=bean.getPass();
		String ans=bean.getAns();
//		String chk=ubean.getChkPass();
		System.out.println(name);
		System.out.println(email);
		Connection con;
		PreparedStatement pstm;
		int i=0;
		try
		{
			con=ConnectionProvider.createC();
			pstm=con.prepareStatement("insert into users values(?,?,?,?,?)");
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, phno);
			pstm.setString(4, ans);
			pstm.setString(5, pass);
//			pstm.setString(6, chk);
			i=pstm.executeUpdate();
		}catch(Exception e) {
			System.out.print(e);
		}
		return i;
	}

}
