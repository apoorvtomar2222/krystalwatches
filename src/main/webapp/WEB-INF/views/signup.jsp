<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>signup</title>
<c:import url="head-meta.jsp" />
</head>


<body>
	<c:import url="head.jsp" />
	<br>
	<br>
	<br>
	<br>
	<br>


	<div align="center">

		<c:if test="${not empty passwordmismatch}">
			<br>
			<label class="alert alert-danger">Password Mismatch</label>
			<br>
		</c:if>

		<c:if test="${not empty useralreadyexists}">
			<br>
			<label class="alert alert-danger">Username Already Exists</label>
			<br>
		</c:if>

		<c:if test="${not empty success}">
			<br>
			<label class="alert alert-success">User Created Successfully</label>
			<br>
		</c:if>

		<form:form action="insertuser" method="post" modelAttribute="newuser">
			<table>
				<tr>
					<td colspan="2" align="center"><h2>Sign Up</h2></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input type="" class="btn btn-lg" path="Username" />
						<label class="text text-danger"><form:errors
								path="username" /></label></td>

				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input type="password" class="btn btn-lg"
							path="Password" />
					<label class="text text-danger">
					<form:errors path="password" /></td>
					</td>

				</tr>


				<tr>
					<td>Confirm Password:</td>
					<td><form:input type="password" class="btn btn-lg"
							path="cPassword" /></td>

				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="Email" class="btn btn-lg" type="" /><label class="text text-danger"><form:errors path="email" /></td>




				</tr>

				<tr>
					<td>Contact No:</td>
					<td>
					<form:input path="Phone" class="btn btn-lg" type="" />
						<label class="text text-danger"><form:errors path="phone" /></td>
				
					
					
					</td>
					
				</tr>



				<tr>
					<td>Address</td>
					<td>
					<form:input path="address" class="btn btn-lg" type="" />
						<label class="text text-danger"><form:errors path="address" /></td>
				
					</td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Sign Up" class="btn btn-success" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<br>
	<br>

</body>
</html>