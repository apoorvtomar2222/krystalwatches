<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:import url="head-meta.jsp" />

</head>
<body>
	<c:import url="head.jsp" />

	<br>
	<br>
	<br>
	<br>

	<div class="container">


		<form:form action="${pageContext.request.contextPath}/updateproduct"
			method="post" modelAttribute="newproduct2"
			enctype="multipart/form-data">

			<form:input type="hidden" path="productId" />

			<table>
				<tr>
					<td>Product Name :</td>
					<td><form:input path="productName" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="productDescription" /></td>
				</tr>
				<tr>
					<td>Category :</td>
					<td><form:input path="productCategory" /></td>
				</tr>

				<tr>
					<td>Quantity :</td>
					<td><form:input path="productQty" /></td>
				</tr>


		

				<tr>

					<td ><form:label path="productImage" for="productImage">Image:</form:label>
</td>
<td>
						<label class="form-control"><span id="file_display1">Choose
								Image</span><span style="position: relative;"> <form:input
									path="productFile" onchange="changeFileDisplay1();" type="file"
									style="opacity:0;" class="form-control" id="imageFile1" /></span></label> <script
							type="text/javascript">
										function changeFileDisplay1() {
											document
													.getElementById("file_display1").innerHTML = $(
													'#imageFile1').val();
											;
										}
									</script></td>
	
	
				</tr>
					
					
							<tr>
					<td colspan="2"><input type="submit" class="btn btn-success " value="Save" /></td>
				</tr>
			

			</table>
			
		</form:form>

	</div>
</body>
</html>