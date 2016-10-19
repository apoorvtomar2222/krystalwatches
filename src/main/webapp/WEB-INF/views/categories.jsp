<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="head-meta.jsp" />


</head>

<script type="text/javascript">
	{

		var myApp = angular.module('myApp', []);

		myApp.controller("abc", function($scope) {
			$scope.data = ${Categories};
			$scope.search = '${param.item}';
		})
	};
</script>



<body ng-app="myApp" ng-controller="abc">

	<c:import url="head.jsp" />



	<br>
	<br>

	<br>
	<br>
	<div class="container">


							<a href="addcategory"
			class="button4 btn-center btn-success btn pull-right" align="right">Add
			Category</a>
					
			
			<br>
		<br>
		<table class="table ">

			<tbody>
				<tr ng-repeat="x in data | filter:search ">
					<input type="hidden" value="{{ x.Product_Id }}" />

<td>
					<label>Category Name :&nbsp;{{x.CategoryName}}</label>
					
										
							<div class="btn1">
								<a
									href="updatecategory/{{x.CategoryId}}"
									class="button3">UPDATE</a>
							</div>
	
							<div class="btn1">
								<a
									href="DeleteCategoryFromDB/{{x.CategoryId}}"
									class="button3">DELETE</a>
							</div>
					
						
					</td>
			</tbody>


		</table>
	</div>
</body>
</html>