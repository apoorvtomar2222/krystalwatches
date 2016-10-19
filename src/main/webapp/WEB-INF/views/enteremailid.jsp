<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<c:import url="head-meta.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot PAssword</title>
</head>
<body>
<c:import url="head.jsp"></c:import>
<br>
<br>
<br>
<br>

<div class="container ">
<div class="table">
<div class="row">

	<h1><center>Enter Your Registered Email Id</center></h1>
	<form  action="emailconfirm1" method="Post" ModelAttribute="forgot">
	<br style="clear: both">
	<div class=" form-group text-center">
	<input type="email"  id="email" size="30" name="email" placeholder="Enter Registered Email ID" required>
	<br>
	<br>
	
	
	<input type="submit" id="submit" class="btn btn-success " value="Reset Password">
								
	</div>
	</form>
</div>
</div>
</div>
</body>

</html>