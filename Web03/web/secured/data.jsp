
<%@page import="java.util.List"%>
<%@page import="objects.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Private data</title>
        <link  rel="stylesheet" type="text/css" href="secured/data.css">
    </head>
    <body>
        <div>
            <div >
                <% User u = (User) session.getAttribute("Curr");%>
                <div class="sqr">
                    <div>Name: <%=u.name%></div>
                    <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div>
                </div></div>
            <form action="SingleServlet" method="post">
                <div class="Main">
                    <div >
                        <button class="btn1" name="button" style="margin: 0 auto;" type="submit" value="SingleGame" >SingleGame</button>
                    </div>
                    <div> <input  value="m" hidden/></div>
                    <div >
                        <button class="btn2" name="button" type="submit" style="margin: 0 auto;" value="MultiGame" >MultiGame</button>
                    </div>  
                </div>

            </form>

        </div>

    </body>
</html>