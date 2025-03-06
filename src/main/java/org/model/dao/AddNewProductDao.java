package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mis.ConnectionProvider;
import org.model.bean.ProductBean;

public class AddNewProductDao {

	public int insert(ProductBean pbean) {
		// TODO Auto-generated method stub
		
		String id=pbean.getId();
		String name=pbean.getName();
		String category=pbean.getCategory();
		String price=pbean.getPrice();
		String active=pbean.getActive();
		
		Connection con;
		PreparedStatement pstm;
		int i=0;
		try
		{
			con=ConnectionProvider.createC();
			pstm=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstm.setString(1, id);
			pstm.setString(2, name);
			pstm.setString(3, category);
			pstm.setString(4, price);
			pstm.setString(5, active);
			i=pstm.executeUpdate();
			System.out.println(i);
		}catch(Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return i;
	}

}
