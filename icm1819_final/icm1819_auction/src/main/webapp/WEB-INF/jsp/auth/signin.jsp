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

<!--
    <link rel="manifest" href="/static/manifest.json">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/main.css">
-->

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

			<form class="form-container">
				<div class="form-title">Login</div>
				<div class="form-item">
					<label class="form-label" for="username">Username</label> <input
						type="text" class="form-text-input" id="username" name="username"
						placeholder="Username" required="" value="guest">
				</div>
				<div class="form-item">
					<label class="form-label" for="password">Password</label> <input
						type="password" class="form-text-input" id="password"
						name="password" placeholder="Password" required="" value="1234">
				</div>
				<button type="submit" class="form-submit primary-button">Sign in</button>
			</form>
		</div>
	</div>

</body>
</html>