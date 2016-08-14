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
<title>Insert title here</title>
</head>
<body>
	<c:import url="head.jsp" />

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
							<form>
								<br style="clear: both">

								<h3 style="margin-bottom: 40px; text-align: center;">Contact
									Form</h3>
								<div class="form-group">
									<input type="name" class="form-control" id="name" name="name"
										placeholder="What Can we call you" required>
								</div>
								<div class="form-group">
									<input type="email" class="form-control" id="email"
										name="email" placeholder="Email" required>
								</div>

								<div class="form-group">
									<textarea class="form-control" type="textarea" id="message"
										placeholder="Message" maxlength="140" rows="7"></textarea>

								</div>

								<button type="button" id="submit" name="submit"
									class="btn btn-success pull-center">Submit Form</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>















</body>
</html>