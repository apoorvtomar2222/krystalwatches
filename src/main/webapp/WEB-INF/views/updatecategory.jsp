<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="head-meta.jsp"></c:import>
<title>Insert title here</title>
</head>

<body>

<c:import url="/head"/>
<br>
<br>

<br>
<br><br>
<br>

<div class="container">
            
                <h2 class="title"><b>Update Category</b></h2>
                <div class="box-content">
                    <p class="description">
                    
                    <form:form method="POST" action="${pageContext.request.contextPath}/UpdateCategoryToDB" modelAttribute="Category">
                    
                    	<form:label path="categoryName">Enter Category Name:</form:label>
                    	
                    	<form:input type="text" path="categoryName" class="form-control"/>
                    
                    	<form:input path="id" type="hidden"/>
                    
                    	<br>
                    	<input type="submit" class="btn btn-success" value="Update"/>
                    
                    </form:form>
                    
                    </p>  
                </div>
        
    </div>  
</div>
 </body> </html>