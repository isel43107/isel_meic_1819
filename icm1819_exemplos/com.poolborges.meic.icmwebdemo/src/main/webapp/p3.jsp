
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGPFACRID</title>
        <script type="text/javascript">
            <%! %>
        </script>
    </head>
    <body>
        <h1>JSP Implicit Objects</h1>
        <p>
            JSP elements: Scriptlet, declaration, and expression
        </p>
        
        
        <br/>
        <%
            out.println("O teu ip é " + request.getRemoteAddr());
        %>

        <h2>Jsp Declaration Tag - Declarar Java variavel</h2>
        <%! int data=50; %>  
        <%= "Value of the variable is:"+data %>  

        <h2>Jsp Declaration Tag - Declarate Java metodo</h2>
        <%!   
            int cube(int n){  
            return n*n*n*;  
        }  
        %>  
        <%= "Cube of 3 is:"+cube(3) %>  

        <h2>Jsp Scriptlet Tag</h2>
    </body>
</html>

