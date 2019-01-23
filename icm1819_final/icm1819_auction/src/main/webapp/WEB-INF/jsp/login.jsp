<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="ICM1819-Auction">
        <meta name="author" content="ICM1819-Auction">
        <link rel="icon" href="/assets/img/favicon.ico">

        <title>ICM1819-Auction Login</title>

        <!-- Bootstrap core CSS -->
        <link href="/static/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="/static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="/static/css/signin.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="/assets/js/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="/assets/js/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div class="container">
            
            <form action="/login" method="post" class="form-signin">
                <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
            
                <h3 class="form-signin-heading">Login</h3>
                <div class="form-group">
                    <label for="loginUsernane" class="sr-only">Username</label>
                    <input type="text" name="username" id="loginUsernane" class="form-control" placeholder="Username" required autofocus>      
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

            <c:if test="${param.error ne null}">
                <div class="alert alert-danger" role="alert"> 
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <span class="sr-only">Error:</span>
                    Invalid username and password.
                </div>
            </c:if>
            <c:if test="${param.logout ne null}">
                <div class="alert alert-warning">You have been logged out.</div>
            </c:if>

        </div> <!-- /container -->


        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="/static/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
