<%@page import="objects.User"%>
<%-- 
    Document   : Multiplayer
    Created on : May 29, 2016, 2:58:28 PM
    Author     : revit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Multiplayer Game</title>
        <script src="Maze.js"></script>
        <link  rel="stylesheet" type="text/css" href="Multiplayer.css">
    </head>
    <body>
        <div >
            <% User u = (User) session.getAttribute("Curr");%>
            <div class="sqr">
                <div>Name: <%=u.name%></div>
                <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div>     
            </div></div>
        <div class="progressBar" style="background-color:green;width:0px">0%</div>
        <div class="Main">
            <button type="submit" class="btnP" name="act" title="Hint"> Hint </button>
            <button type="submit" class="btnP" name="act" title="Restart"> Restart </button>
            <button type="submit" class="btnP" name="act" title="Back"> Back </button>
        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(function ($) {
                $(document).ready(function () {
                    $.ajaxSetup({cache: false});
                });
                function long_polling() {
                    $.getJSON('MultiProgress', function (data) {
                        $('.progressBar').width(data.progress).text(data.progress + '%');
                        if (data.progress < 100)
                        {
                            long_polling();
                        } else {
                            generate_table(data.Maze, 13, 0, 4, 3, 4);
                            generate_table(data.Maze, 13, 3, 3, 1, 5);
                            $('.progressBar').hide();
                        }
                    });
                }
                long_polling();
            });
        </script>
    </body>
</html>