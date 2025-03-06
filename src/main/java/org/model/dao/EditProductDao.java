package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mis.ConnectionProvider;
import org.model.bean.ProductBean;

public class EditProductDao {

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
			pstm=con.prepareStatement("update product set name='"+name+"',category='"+category+"',price='"+price+"',active='"+active+"' where id='"+id+"'");
			if(active.equals("No")) {
				pstm.executeUpdate("Delete from cart where product_id='"+id+"' and address is NULL'");
			}
			i=pstm.executeUpdate();
			System.out.println(i);
		}catch(Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return i;
	}

}
