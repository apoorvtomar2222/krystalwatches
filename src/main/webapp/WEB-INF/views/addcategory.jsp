<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Category</title>
	<c:import url="head-meta.jsp" />

</head>


<body>
	<c:import url="head.jsp" />

	<br>
	<br>
	<br>
	<br>



	<form:form action="AddCategoryToDB" method="post"
		modelAttribute="Category" >
		<br><br><br><br>
		<div class="container">

			<table>
			
			<tbody>
			<tr>
			<td>
			
                    	<form:label path="categoryName">Enter Category Name:</form:label>
                    	
                
                    	<form:input type="text" path="categoryName" class="form-control" id="usr" />
                    	<br>

					<input type="submit" class="btn btn-success pullright" value="Add"/>


              </td>
              </tr>
            </tbody>        
				
            </table>        
		</div>
	</form:form>
	<br>
	<br>
</body>
</html>