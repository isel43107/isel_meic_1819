<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<spring:url value="css/app.css" />" rel="stylesheet" type="text/css">
        <title>ICM1819-Auction</title>
    </head>
    <body class="security-app">
        <div class="details">
            <h2>Page Comissão Financeiro</h2>
            <a href="#" class="button green small">Menu 1</a> 
            <a href="#" class="button red small">Menu 2</a>
        </div>
        <div class="lc-block">
            <h1>Welcome!</h1>
            <div class="alert-normal">
                Click <a href="<spring:url value='/hello' />">here</a> to see a
                greeting.
            </div>
        </div>
    </body>
</html>
