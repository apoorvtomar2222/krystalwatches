<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Bootstrap Example</title>


<c:import url="head-meta.jsp" />


</head>

<script type="text/javascript">
	{

		var myApp = angular.module('myApp', []);

		myApp.controller("abc", function($scope) {
			$scope.data = ${data};
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

		<a href="addproduct"
			class="button4 btn-center btn-success btn pull-right" align="right">Add
			Product</a> <input type="text" placeholder="Search Product"
			ng-model="searchProduct.ProductName" /> <input type="hidden"
			value="{{ x.Product_Id }}" /> 
			<br>
		<br>
		<table class="table ">

			<thead>
				<tr>


					<th>Product NAme</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Image</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="x in data | filter:searchProduct ">
					<input type="hidden" value="{{ x.Product_Id }}" />

					<td>{{x.ProductName}}</td>
					<td>{{x.ProductPrice}}</td>
					<td>{{x.ProductQty}}</td>
					<td><img
						ng-src="${pageContext.request.contextPath}/{{ x.flag }}"
						height=" 150px" width="200px"></td>

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
			</tbody>


		</table>
	</div>
</body>
</html>