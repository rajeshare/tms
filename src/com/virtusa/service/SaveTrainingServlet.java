package com.virtusa.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;
import com.virtusa.dao.RoleDao;
import com.virtusa.dao.TrainingDao;


@WebServlet("/SaveTrainingServlet")
public class SaveTrainingServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String trainingName=request.getParameter("trainingName");
		String trainingType=request.getParameter("trainingType");
		String trainingDesc=request.getParameter("trainingDesc");
		
		
		TrainingBean tb=new TrainingBean();
		tb.setTrainingName(trainingName);
		tb.setTrainingType(trainingType);
		tb.setTrainingDesc(trainingDesc);
		
		if(TrainingDao.saveTrainings(tb)) {
			 RequestDispatcher rd=request.getRequestDispatcher("SaveTrainingServlet2");  
		     rd.forward(request,response);  
		}else {
			 pw.print("Sorry trainingDetails details not inserted");  
			
			 RequestDispatcher rd=request.getRequestDispatcher("trainings.jsp");
			 rd.include(request,response);
	 		   
	      }
      } 
   }
