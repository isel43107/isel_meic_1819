<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
		<meta charset="UTF-8">
		<title>Sign up success</title>
	</head>
	<body>
		<div class="container">
		    <h1 class="alert alert-success" th:text="#{sigin.success}">success</h1>
		    <a th:href="@{/login}" th:text="#{label.login}">login</a>
		</div>        
	</body>
</html>

