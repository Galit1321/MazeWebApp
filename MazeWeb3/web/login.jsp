<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Form</title>
    </head>
     <link  rel="stylesheet" type="text/css" href="loginStyle.css"></link>
    <body>
        <div class="Main">
            <form action="MyFormServlet" method="post">
            <div>Username:
                <div>
                    <input class="Field" type="text" name="username" />
                </div>
                </div>
            <div>Password:</div>
            <input type="password" name="password" />
            <input type="submit"/>
            <% if (request.getAttribute("error") != null
            && (Boolean) request.getAttribute("error")) {%>
            <div>Wrong username/password. Please try again</div>
            <% }%>
        </form>
        </div>
       
    </body>
</html>