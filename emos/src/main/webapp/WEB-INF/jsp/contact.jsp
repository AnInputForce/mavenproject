<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Contact Manager</h2>
<s:form method="post" action="addContact.html">

	<table>
	<tr>
		<td><s:label path="firstname">First Name</s:label></td>
		<td><s:input path="firstname" /></td> 
	</tr>
	<tr>
		<td><s:label path="lastname">Last Name</s:label></td>
		<td><s:input path="lastname" /></td>
	</tr>
	<tr>
		<td><s:label path="lastname">Email</s:label></td>
		<td><s:input path="email" /></td>
	</tr>
	<tr>
		<td><s:label path="lastname">Telephone</s:label></td>
		<td><s:input path="telephone" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Contact"/>
		</td>
	</tr>
</table>	
	
</s:form>
</body>
</html>
