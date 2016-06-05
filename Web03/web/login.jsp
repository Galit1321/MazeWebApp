
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page session="false"%>
    <head>
        <title>My Form</title>
     <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
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
                    <input type="submit" class="bnt" name="act" value="Enter"/>
                </div>

            </form>
                <form action="SubscribeServlet" method="get">
                         <input type="submit" class="bnt" name="act" value="Subscribe"/>
                </form>
                
        </div>

    </body>
</html>