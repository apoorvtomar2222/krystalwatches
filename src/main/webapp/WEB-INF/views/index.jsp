<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Bootstrap Example</title>


<c:import url="head-meta.jsp" />

</head>


<body>



	<c:import url="head.jsp" />





	<br>
	<br>
	<br>
	<br>

	<div class=container>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators ">
				<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="ab carousel-inner" role="listbox">


				<div class="kd item active">
					<img src="resources/images/watch1.jpg" alt="Chania">
				</div>


				<div class="kd item">
					<img src="resources/images/watch2.jpg" alt="Chania">
				</div>

				<div class="kd item">
					<img src="resources/images/watch3.jpg" alt="Flower">
				</div>
				<div class="kd item">
					<img src="resources/images/watch4.jpg" alt="Flower">
				</div>


				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>


















	<div class=" container">


		<div class="display img img-responsive">

			<div>
				<div class="cir col-md-4">

					<img src="resources/images/formal.jpg" class=" img-circle "
						alt="Cinque Terre" width="100%" height="236">
					<h3 class="kd">Mens Stylise watch</h3>

				</div>
				<div class="cir col-md-4">
					<img src="resources/images/women.jpg" class=" img-circle "
						alt="Cinque Terre" width="100%" height="236">
					<h3>Women Antique Watches</h3>

				</div>


				<div class="cir col-md-4">
					<img src="resources/images/sports.jpg" class=" img-circle"
						alt="Cinque Terre" width="100%" height="236"> <br>
					<h3>Sporty,Water Proof watches</h3>

				</div>
			</div>

		</div>
	</div>

</body>
</html>

