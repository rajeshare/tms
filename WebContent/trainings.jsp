<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>

<style>
#h1 {
  margin-left: 20%;
}
</style>
</head>
<body>
<%@include file="HomePage.jsp" %>
<%@include  file="myActivitiesSidePanel.jsp" %>
<form action="SaveTrainingServlet" method="POST">

<div id=h1>
<h1>Add Trainings</h1>
Training Name:<input type="text" name="trainingName" required="required"><br><br>

Training Type:<input type="text" name="trainingType"><br><br>
Training Desc:<input type="text" name="trainingDesc"><br><br>
<input type="submit" name="submit" value="Submit">
  
  </div>
  </form>
</body>
</html>