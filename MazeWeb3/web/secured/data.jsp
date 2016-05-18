<%@page import="objects.Record" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Private data</title>
    </head>
    <body>
        <div>
            <div>Your balance:</div>
            <%List<Record> list = (ArrayList) session.getAttribute("list");
    for (Record r : list) {%>
            <div><%= r.getDesc()%></div>
            <div><%= r.getValue()%></div>
            <div><%= r.isDeposite()%></div>
            <%}%>
        </div>
    </body>
</html>