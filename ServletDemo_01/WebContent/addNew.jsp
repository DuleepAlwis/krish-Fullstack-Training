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
				<tr><td>Employee id : </td><td><input type="number" value="" name="id"/></td></tr>
				<tr><td>Employee name : </td><td><input type="text" value="" name="name"/></td></tr>
				<tr><td>Address </td><td><input type="text" name="address"/></td></tr>
				<tr><td><input type="submit" value="Save"/></td><td><input type="reset" value="Clear"/></td></tr>
				
			</table>
		</form>
		
		
	</div>
</div>
</body>
</html>