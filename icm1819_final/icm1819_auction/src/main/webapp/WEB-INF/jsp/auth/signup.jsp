<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="theme-color" content="#000000">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/LoginPage.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<title>JP Auction</title>
</head>
<body>

	<div id="root">
		<div class="login">
			<div class="topbar sidebar-color">
				<a class="topbar-logo-link" href="/"> JP Auction <!--
                    <img class="topbar-logo" alt="JP Auction" src="data:image/png;base64,">
                    -->
				</a>
			</div>
			<div class="form-container">
				<div class="form-title">Registration</div>
				<form>
					<div class="form-group row">
						<label for="fullname" class="col-sm-2 col-form-label">Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="fullname"
								name="fullname" value="" placeholder="Name">
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="email" name="email"
								path="email" placeholder="E-mail" required="true" />
						</div>
						<span id="emailError" class="alert alert-danger col-sm-2"
							style="display: none"></span>
					</div>
					<div class="form-group row">
						<label for="username" class="col-sm-2 col-form-label">Username</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username"
								name="username" value="" placeholder="Chose a username">
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password">
						</div>
					</div>
					<button type="submit" class="form-submit primary-button">Sign
						Up</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>