<%@page import="java.util.List"%>
<%@page import="objects.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Private data</title>
        <link  rel="stylesheet" type="text/css" href="data.css">
    </head>
    <body>
        <div>
            <from action="Close" method="post">
                <div >
                    <% User u = (User) session.getAttribute("Curr");%>
                    <div class="sqr">
                        <div>Name: <%=u.name%></div>
                        <div><image src="<%=u.icon%>" width="50" height="50"/></div>
                        <form action="../LogOutServlet" method="post" >
                            <button class="gsBtn" name="logOut" type="submit" value="LogOut">LogOut</button>
                        </form>
                    </div></div>
            </from>
            <form action="SingleServlet" method="post">
                <div class="Main">
                    <button class="oBtn" name="button"  type="submit" value="SingleGame" >Single Game</button>
                    <button class="pBtn" name="button" type="submit" value="MultiGame" >MultiGame</button>
                </div>
            </form> 
        </div>
        <img src="pic/logo.jpg" alt="logo" width="150" height="150">
        <h1 style="color: mediumturquoise">Flower Maze</h1>
    </body>
</html>>