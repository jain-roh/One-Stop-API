<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!---*************welcome this is my simple empty strap by John Niro Yumang ******************* -->

<html lang="en">

	<title>Sign up One Stop API</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<head>
		<script src="jquery/jquery.min.js"></script>
		<!---- jquery link local dont forget to place this in first than other script or link or may not work ---->
		
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!---- boostrap.min link local ----->
		
		<link rel="stylesheet" href="css/style.css">
		<!---- boostrap.min link local ----->

		<script src="js/bootstrap.min.js"></script>
		<!---- Boostrap js link local ----->
		
		<link rel="icon" href="images/icon.png" type="image/x-icon" />
		<!---- Icon link local ----->
		
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
	<style>
	body {background-color:#eee;}
.container-fluid {padding:50px;}
.container{background-color:white;padding:50px;   }
#title{font-family: 'Lobster', cursive;;}
	</style>
		<!---- Font awesom link local ----->
	</head>
	<body>
	<div class="container-fluid">
		<div class="container">
			<h2 class="text-center" id="title">One Stop API</h2>
		
 			<hr>
			<div class="row">
				<div class="col-md-5">
 					<form role="form" method="post" action="signup.htm" >
						<fieldset>							
							<p class="text-uppercase pull-center"> SIGN UP.</p>	
 							<div class="form-group">
								<input type="text" id="username" name="name" class="form-control input-lg" placeholder="Name"/>
							</div>

							<div class="form-group">
							<input type="email" id="email" name="userName" class="form-control input-lg" placeholder="Email Address"/>
							</div>
							<div class="form-group">
							<input type="password" id="password" name="userPassword" path="userPassword" class="form-control input-lg" placeholder="Password"/>
							</div>
								<div class="form-group">

								<input type="password" name="password2" id="password2" class="form-control input-lg" placeholder="Re-type Password">
							</div>
							<div class="form-group">
							User Typer :
							<input type="radio" value="business" name="type"/> Business
							<input type="radio" value="user" name="type"/> User

							</div>
							<div class="form-check">
								<label class="form-check-label">
								  <input type="checkbox" class="form-check-input">
								  By Clicking register you're agree to our policy & terms
								</label>
							  </div>
 							<div>
 									  <input type="submit" class="btn btn-lg btn-primary   value="Register">
 							</div>
						</fieldset>
					</form>
				</div>
				
				<div class="col-md-2">
					<!-------null------>
				</div>
				
				<div class="col-md-5">
 				 		<form role="form" method="post" action="login.htm">
						<fieldset>							
							<p class="text-uppercase"> Login using your account: </p>	
 								
							<div class="form-group">
								<input type="email" name="userName" id="username" class="form-control input-lg" placeholder="username">
							</div>
							<div class="form-group">
								<input type="password" name="userPassword" id="password" class="form-control input-lg" placeholder="Password">
							</div>
								User Type :
							<input type="radio" value="business" name="type"/> Business
							<input type="radio" value="user" name="type"/> User
							
							<div>
								<input type="submit" class="btn btn-md" value="Sign In">
							</div>
								 
 						</fieldset>
				</form>	
				</div>
			</div>
		</div>

	</div>
	</body>
	 

</html>