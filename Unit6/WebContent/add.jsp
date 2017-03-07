<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
<form action="EmployeeServlet">
<label>Name</label> <input type="text" name="name"><br>
<label>Department</label> <input type="text" name="dept"><br>
<label>Gender</label> <input type="text" name="gender"><br>
<label>Country</label> <input type="text" name="country"><br>
<label>Salary</label> <input type="text" name="salary"><br>
<input type="submit" name="btnSubmit" value="add new employee">
</form>
</body>
</html>