<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
		<meta charset="UTF-8">
		<title>Sign up confirmation</title>
	</head>
	<body>
		<div>
		<h1 class="alert alert-info" th:text="#{sigin.confirm.success}">success</h1>
		<br/>
		<span th:if="${param.token != null}" th:text="#{token.message}">token</span>
		<span th:text="${param.token}">token</span>
		<br/>
		<a class="btn btn-primary" th:href="signin" th:text="#{label.login}">login</a>
		</div>          
	</body>
</html>
