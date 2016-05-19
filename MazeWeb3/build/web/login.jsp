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
                        <input class="Field" type="text" name="username" />
                    </div>
                </div>
                <div>Password:</div>
                <input class="Field" type="password" name="password" />
                <div>
                    <input type="submit" class="bnt" name="act" value="Subscribe"/>
                    <input type="submit" class="bnt" name="act" value="Enter"/>
                    <% if (request.getAttribute("error") != null
                                && (Boolean) request.getAttribute("error")) {%>
                    <div>Wrong username/password. Please try again</div>
                    <% }%>
                </div>

            </form>
        </div>

    </body>
</html>