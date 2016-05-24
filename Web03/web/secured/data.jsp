
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
        <div >
            <% User u = (User) session.getAttribute("Curr"); %>
            <div class="sqr">
            <div>Name: <%=u.name %></div>
            <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div>
            </div></div>
            <div class="Main">
                <div ><button class="btn1" type="submit" value="SingleGame" >Single Game</button></div>
                      <div >
                          <button class="btn2" type="submit" value="MultiGame" >MultiGame</button>
                      </div>
                       
            </div>
        
    </body>
</html>