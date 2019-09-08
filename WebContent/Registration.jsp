<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1><center>Registration</center></h1>

</head>
<body>
<form action="SaveRegistrationServlet" method="POST">
<center> 
First Name:<input type="text" name="userFirstname"/><br/><br/>
Last Name:<input type="text" name="userLastname"/><br/><br/>
Email:<input type="email" name="userEmail"/><br/><br/>
Date Of Birth:<input type="date" name="userDOB"/><br/><br/>
Address:<input type="text" name="userAddress"/><br/><br/>
 
User Name:<input type="text" name="userName"/><br/><br/>
Password:<input type="password" name="userPassword"/><br/><br/>  
Confirm Password:<input type="password" name="userConfirmPW"><br/><br/>
<input type="submit" name="submit"><br>
</center>
</form></body>
</html>