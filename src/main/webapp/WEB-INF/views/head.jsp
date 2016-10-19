<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page isELIgnored="false"%>


<nav class="navbar navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="#"><font size="5">Krystal
					Watches<sup>&#169;</sup>
			</font></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/index">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/aboutus">About
						Us</a></li>
				<li><a href="${pageContext.request.contextPath}/contact_us">Contact
						Us</a></li>
				<li><a href="${pageContext.request.contextPath}/product">Products</a></li>
				<li><a href="${pageContext.request.contextPath}/categories">Category</a></li>
				
				
				
									<%
						if (request.isUserInRole("ADMIN"))
						{
							%>
				<li><a href="${pageContext.request.contextPath}/userbase">Userbase</a></li>
							<%							
						}
						%>

			
				
					<%
						if (request.isUserInRole("USER"))
						{
							%>
	<li><a href="${pageContext.request.contextPath}/initiateFlow" >View Cart</a></li>
							<%							
						}
						%>


				
			</ul>


			

			<ul class="nav navbar-nav navbar-right">
               
               
               
               
				<c:choose>
					<c:when test="${not empty pageContext.request.userPrincipal}">
						<li><a href="${pageContext.request.contextPath}/index">${pageContext.request.userPrincipal.name}</a></li>
						<li><a href="${pageContext.request.contextPath}/logout">Log
								Out</a></li>

					</c:when>

					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/signup"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="${pageContext.request.contextPath}/loginpage"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:otherwise>
				</c:choose>


			</ul>
		</div>
	</div>
</nav>


<footer> Krystal Watches </footer>

