<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Form</title>
        <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
    </head>
    <link  rel="stylesheet" type="text/css" href="loginStyle.css"></link>
    <script src="login.js">
    </script>
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