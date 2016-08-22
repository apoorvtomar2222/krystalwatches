<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<c:import url="head-meta.jsp" />

</head>

<script type="text/javascript">
	{

		var myApp1 = angular.module('myApp1', []);

		myApp1.controller("abc1", function($scope) 
				
				{
			$scope.data = ${data1};
		})
	};
</script>



<body ng-app="myApp1" ng-controller="abc1">

	<c:import url="head.jsp" />



	<br>
	<br>

	<br>
	<br>
	<div class="container">

		<%-- 
					<%
						if (request.isUserInRole("ADMIN"))
						{
							%>
							<%							
						}
						%>
 --%>



		<input type="text" placeholder="Search Product" ng-model="search" />
		<input type="hidden" value="{{ x.Product_Id }}" /> <br> <br>
		<table class="table ">

			<thead>
				<tr>


					<th>Email</th>
					<th>Username</th>
					<th>Phone</th>
					<th>Password</th>
					<th>Role
					<th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="x in data | filter:search ">
					

					<td>{{x.Email}}</td>
					<td>{{x.Username}}</td>
					<td>{{x.Phone}}</td>
					<td>{{x.Password}}</td>
					<td>{{x.Role}}
				
				
				
					<td>
						<div class="btn1">
							<a href="${pageContext.request.contextPath}/view/{{x.ProductID}}"
								class="button3 ">VIEW</a>
						</div>

							<div class="btn1">
								<a
									href="${pageContext.request.contextPath}/update/{{x.ProductID}}"
									class="button3">UPDATE</a>
							</div>
	
							<div class="btn1">
								<a
									href="${pageContext.request.contextPath}/delete/{{x.ProductID}}"
									class="button3">DELETE</a>
							</div>

						
					</td>
			</tr>
			</tbody>
			


		</table>
	</div>
</body>
</html>
</body>
</html>