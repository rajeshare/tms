package com.virtusa.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.dao.RegisterDao;


@WebServlet("/SaveLoginServlet")
public class SaveLoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		String uname=request.getParameter("uName");
		String passWord=request.getParameter("passWord");
		
		if(RegisterDao.loginValidate(uname,passWord)) {
			pw.println("User Name and Password Exist");
			
			HttpSession session = request.getSession();
            session.setAttribute("user", uname);

            RequestDispatcher rd=request.getRequestDispatcher("trainings.jsp");
			rd.forward(request, response);
		}else {
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			pw.println("User Name and Password Not exist");
			rd.include(request, response);
		}
		
		
	}

}
