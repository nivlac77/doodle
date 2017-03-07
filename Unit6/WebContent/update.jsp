<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="exercise1.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>

<%
	DBConnection db = new DBConnection();
	int id = Integer.parseInt(request.getParameter("selectedEmployee"));
	System.out.println(id);
	Employee e = db.findEmployeeById(id);
%>
<form action="EmployeeServlet">
<label>Name</label> <input type="text" name="name" value="<%=e.getName()%>"><br>
<label>Department</label> <input type="text" name="dept" value="<%=e.getDepartment()%>"><br>
<label>Gender</label> <input type="text" name="gender" value="<%=e.getGender()%>"><br>
<label>Country</label> <input type="text" name="country" value="<%=e.getCountry()%>"><br>
<label>Salary</label> <input type="text" name="salary" value="<%=e.getSalary()%>"><br>
<input type="hidden" name="employeeId" value="<%=id%>">
<input type="submit" name="btnSubmit" value="update">
</form>
</body>
</html>