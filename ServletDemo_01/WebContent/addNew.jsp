<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new employee</title>
</head>
<body>
<div>
	<div>
		<form action="EmployeeServlet" method="POST">
			<table>
				<tr><td>Employee name : </td><td><input type="text" value="" name="name"/></td></tr>
				<tr><td>Employee DOB : </td><td><input type="date" value="" name="dob"/></td></tr>
				<tr><td>Salary </td><td><input type="text" name="salary"/></td></tr>
				<tr><td><input type="submit" value="Save"/></td><td><input type="reset" value="Clear"/></td></tr>
				
			</table>
		</form>
		
		
	</div>
</div>
</body>
</html>