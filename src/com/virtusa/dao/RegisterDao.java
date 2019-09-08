package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.virtusa.bean.EmployeeBean;



public class RegisterDao {

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
	
	public static boolean save(EmployeeBean e){
		boolean b=false;
		int status=0;
		try{
			Connection con=RegisterDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into userDetails(id,fname,lname,email,dob,address,username,password) values (?,?,?,?,?,?,?,?)");
		    ps.setInt(1, getId());
			ps.setString(2,e.getFirstName());
			ps.setString(3,e.getLastName());
			ps.setString(4,e.getEmail());
			ps.setString(5,e.getDob());
			ps.setString(6,e.getAddress());
			ps.setString(7,e.getUserName());
			ps.setString(8,e.getPassword());
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
	    PreparedStatement ps=con.prepareStatement("select count(*) from userDetails");
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
	public static boolean loginValidate(String uname,String pw) {
		boolean b=false;
		try {
			   Connection con=RegisterDao.getConnection();
			   Statement stmt=con.createStatement();  
			   String query = "SELECT username, password FROM userDetails";
	            ResultSet rs = stmt.executeQuery(query);
               while (rs.next()) {
	            String userName = rs.getString("username");
	            String passWord =  rs.getString("password");
	           
	               if ((uname.equals(userName)) && (pw.equals(passWord))) {

	            	   return true;
	            	   
	            	   
	                 
	            }
//	               else {
//                      return false;
//	             }
	            }
	               rs.close();
			       con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
   }
