<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "exercise1.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees app</title>
</head>
<body>
	<a href="add.jsp">Add New Employee</a>
	<form action="EmployeeServlet">
		<select name="filter">
			<option value="findAll">find all</option>
			<option value="sortBySalary">sort by salary</option>
			<option value="findMale">find men</option>
			<option value="findFemale">find women</option>
		</select> <input type="submit" name="btnSubmit" value="Apply">
	</form>
	<table border=1>
		<tr>
			<th>NAME</th>
			<th>DEPARTMENT</th>
			<th>GENDER</th>
			<th>COUNTRY</th>
			<th>SALARY</th>
		</tr>
		<%
			ArrayList<Employee> allEmps = (ArrayList<Employee>) session.getAttribute("employees");
			if(allEmps == null){
				DBConnection connection = new DBConnection();
				allEmps = connection.findAllEmployees();
				session.setAttribute("employees", allEmps);
			}
			
			
			
			for(Employee e : allEmps){
				out.println("<tr>");
				out.println("<td>" + e.getName() + "</td>");
				out.println("<td>" + e.getDepartment() + "</td>");
				out.println("<td>" + e.getGender() + "</td>");
				out.println("<td>" + e.getCountry() + "</td>");
				out.println("<td>" + e.getSalary() + "</td>");
				out.println("<td><form action=\"update.jsp\"><input type=\"hidden\" name=\"selectedEmployee\" value=" + e.getId() + ">" +
				"<input type=\"submit\" name=\"btnSubmit\" value=\"update\"></form></td>");
				out.println("<td><form action=\"EmployeeServlet\"><input type=\"hidden\" name=\"selectedEmployee\" value="+e.getId()+">"+
				"<input type=\"submit\" name=\"btnSubmit\" value=\"delete\"></form></td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>