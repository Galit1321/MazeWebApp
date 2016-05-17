<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Form</title>
    </head>
    <body>
        <form action="MyFormServlet" method="post">
            <%
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                out.println("<div>Current time=" + sdf.format(cal.getTime()) + "</div>");
            %>
            <div><%= (new Double(8))%></div>
            <div>Username:</div>
            <input type="text" name="username" />
            <div>Password:</div>
            <input type="password" name="password" />
            <input type="submit"/>
            <% if (request.getAttribute("error") != null
            && (Boolean) request.getAttribute("error")) {%>
            <div>Wrong username/password. Please try again</div>
            <% }%>
        </form>
    </body>
</html>