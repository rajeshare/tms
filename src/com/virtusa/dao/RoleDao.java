package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.virtusa.bean.EmployeeBean;
import com.virtusa.bean.RoleBean;

public class RoleDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public static boolean saveRoles(RoleBean rb){
		boolean b=false;
		int status=0;
		try{
			Connection con=RoleDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into roleDetails(roleId,roleName,roleDescription) values (?,?,?)");
		    ps.setInt(1, getId());
			ps.setString(2,rb.getRoleName());
			ps.setString(3,rb.getRoleDescription());
			System.out.println("chal nak telvad");
			status=ps.executeUpdate();
			b=true;
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
	   }
		return b;
	}
	
   
	public static int getId() {
		 int id=0;
     try {
	    Connection con=RegisterDao.getConnection();
	    PreparedStatement ps=con.prepareStatement("select count(*) from roleDetails");
	     ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	    } catch (Exception e) {
			e.printStackTrace();
	  }
	    return id;
	}
	
	
}
