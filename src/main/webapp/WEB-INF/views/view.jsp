<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail</title>
<c:import url="head-meta.jsp" />

</head>
	


<script>
function abc(arg) {
    document.getElementById("userRating").value = arg;
    
    console.log( document.getElementById("userRating").value );
}

function setRating()
{
	var currRating = 0;

	try
	{
		currRating = ${currentRating};
	}
	catch(e)
	{
		currRating = 0;
	}
	
	/* switch(currRating)
	{
	case 1:
		document.getElementById("rating-input-1-1").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		break;
		
		
	case 2:
		document.getElementById("rating-input-1-1").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		document.getElementById("rating-input-1-2").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		break;
		
	case 3:
		document.getElementById("rating-input-1-1").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		document.getElementById("rating-input-1-2").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		document.getElementById("rating-input-1-3").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
		
		break;
		
			
	} */
	
	/* alert($("#rating-input-1-1").css( "background-position"));
	
	$("#rating-input-1-1").css({ "background":"url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px" });
	
	alert($("#rating-input-1-1").css( "background-position")); */
	
	var ratingobj = new RatingObject().Constructor("myRating", "50" , "0" , "RatingArea" , "50", "0.95", "1", "0", "Editable", currRating);
	
	
	
	//document.getElementById("rating-input-1-2").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
	//document.getElementById("rating-input-1-3").style.background="url('http://css-stars.com/wp-content/uploads/2013/12/stars.png') 0 0px";
	
}

</script>

<body onload="setRating()">
	<c:import url="head.jsp" />

	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<table class="table">
			<tr>

				<td colspan="2"><img
					src="${pageContext.request.contextPath}/${ProductImg}" width="40%"
					class="img img-responsive img-thumbnail"></img></td>
			</tr>

			<tr>
				<td>Product Name :</td>
				<td>${ProductName}</td>
			</tr>
	
			<tr>
				<td>Description:</td>
				<td>${ProductDescription}</td>
			</tr>
			<tr>
				<td>Category :</td>
				<td>${ProductCategory}</td>
			</tr>

			<tr>
				<td>Price :</td>
				<td>${ProductPrice}</td>
			</tr>




<tr>
<td>Rate the Product</td>
<td>

<!-- <div class="rating-wrapper">
  <input type="radio" onclick="abc(1)" class="rating-input" id="rating-input-1-1" name="rating-input-1" />
  <label for="rating-input-1-1" class="rating-star"></label>
  
  <input type="radio" onclick="abc(2)" class="rating-input" id="rating-input-1-2" name="rating-input-1" />
  <label for="rating-input-1-2" class="rating-star"></label>
  
  <input type="radio" onclick="abc(3)" class="rating-input" id="rating-input-1-3" name="rating-input-1" />
  <label for="rating-input-1-3" class="rating-star"></label>
  
  <input type="radio" onclick="abc(4)" class="rating-input" id="rating-input-1-4" name="rating-input-1" />
  <label for="rating-input-1-4" class="rating-star"></label>
  
  <input type="radio" onclick="abc(5)" class="rating-input" id="rating-input-1-5" name="rating-input-1" />
  <label for="rating-input-1-5" class="rating-star"></label>
</div> -->


<div id="RatingArea" style="margin: auto; width: 95%;"></div>


<div>
	<form action="${pageContext.request.contextPath}/submitRating/${ProductId}" method="post">
		<input type="hidden" value="${ProductId}" name="pid" />
		<input type="hidden" id="userRating" name="rating" />
		<input type="submit" value="Add Rating" class="btn btn-info"/>
	</form>
</div>

</td>
 </tr>  


			
<%
     if (!request.isUserInRole("ADMIN")) {
    	 
        
        %>
        
        	<form action="${pageContext.request.contextPath}/addToCart" method="post">

				<input type="hidden" value="${ProductId}" name="pid" />
				<tr>
					<td>Qty</td>
					<td><input type="number" value="1" min="1" max="10"
						name="pqty" class="form form-input" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add To Cart"
						class="btn btn-success" /></td>
				</tr>
			</form>
<%

}
%>

		</table>
		


</div>
<br><br>
<br><br>
</body>
</html>