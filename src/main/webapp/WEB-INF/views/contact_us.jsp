<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="head-meta.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
	<c:import url="head.jsp" />
<br>
<br><br><br>
	<div class="container">
		<div class="box2 ">
			<div class="col-md-6 col-sm-6">
				<div class="axe">

					<img src="resources/images/cntct1.jpg">


				</div>
			</div>

			<div class="col-md-6 col-sm-6">
				<div class="axe2">
					<img src="resources/images/cntct2.jpg">
					<h3 class="title">
						<b>You Can Reach Us At</b>
					</h3>
					<div class="box-content">
						<div>
							<form action="emailconfrm" method="post">
								<br style="clear: both">

								<h3 style="margin-bottom: 40px; text-align: center;">Contact
									Form</h3>
								<div class="form-group">
									<input type="email" class="form-control" id="email"
										name="email" placeholder="Email" required>
								</div>

							<div class="form-group">
									<input type="Subject" class="form-control" id="Subject" name="subject"
										placeholder="Subject" required>
								</div>
								

								<div class="form-group">
									<textarea class="form-control" type="textarea" id="message" name="message"
										placeholder="Message" maxlength="140" rows="7"></textarea>

								</div>

								<input type="submit" id="submit"
									class="btn btn-success text-center" value="Send Message">
								
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>




<br>
<br>

<br>
<br>
<br>

<br>








</body>
</html>