<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Form</title>
       <script src="jquery-1.12.2.min.js"></script>
        <script src="login.js"></script>
        <link  rel="stylesheet" type="text/css" href="loginStyle.css">
    </head>
    <body>
        <div class="Main">
            <form action="MyFormServlet" method="post">
                <div>Username:
                    <div>
                        <input type="text" name="username" />
                    </div>
                </div>
                <div>Password:</div>
                <input  type="password" name="password" />
                <% if (request.getAttribute("error") != null
                                && (Boolean) request.getAttribute("error")) {%>
                    <div class="text">Wrong username/password. Please try again</div>
                    <% }%>
                <div>
                    <input type="submit" class="bnt" name="act" value="Subscribe"/>
                    <input type="submit" class="bnt" name="act" value="Enter"/>
                </div>

            </form>
        </div>

    </body>
</html>