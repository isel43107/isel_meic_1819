<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGPFACRID</title>
        <script type="text/javascript">
            m = "Hello"; 
            <%! int m = 9; %>
            <%! 
            int f1(){
                m +=8;
                return m + m;
            }
            %>

        </script>
    </head>
    <body>
        <h1>getParameter: <%= request.getParameter("a") %></h1>
        <h1>getAttribute: <%= session.getAttribute("a") %></h1>
       

        <%
            session.setAttribute("a", "key" + m);
            m +=4;
         %>

        <p>F1: <%= f1() %></p>
        <p>a: <%= "a" %></p>
        <p id="field"> a </p>
        Next value id ${a}

        <p>M: <%= m %></p>
    </body>
</html>

