<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <c:import url="/head-meta" />

</head>
<body>
 <c:import url="/head" />
 
 <br>
 <br>
 <br>
 <br>
 
<h1>Page 2</h1>

<a href="${flowExecutionUrl}&_eventId=BackToCart" class="btn btn-danger btn pull-left"><span class="glyphicon glyphicon-chevron-left"></span>PREVIOUS</a>

<a href="${flowExecutionUrl}&_eventId=ViewCompleteOrder" class="btn btn-success btn pull-right">NEXT<span class="glyphicon glyphicon-chevron-right"></span></a>


</body>
</html>