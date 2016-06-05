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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <link  rel="stylesheet" type="text/css" href="Multiplayer.css">
    </head>
    <body >
        <div >
            <% User u = (User) session.getAttribute("Curr");%>
            <div class="sqr">
                <div>Name: <%=u.name%></div>
                <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div> 
                <form action="../LogOutServlet" method="post" >
                    <button class="gsBtn" type="sumbit"  >LogOut </button>
                </form>
            </div></div>
    </div>
    <div class="progressBar" style="background-color:green;width:0px">0%</div>

    <table>
        <tr>
            <td class="Main" style="left: 3%; position: fixed">
                <form action="Close" method="post" onsubmit=" return confirm('Are you sure you want close the game?')">
                    <button type="button" class="BtnS" name="act" title="Hint" onclick="Clue()"> Hint </button>
                    <button type="button" class="BtnS" name="act" title="Restart" onclick="Reset()" > Restart </button>
                    <button type="submit" class="BtnS" name="act" title="Back"> Back </button>
                </form>
            </td>
            <td class="other" style="right: 14%; position: absolute; top: 14%"></td>
        </tr>
    </table>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script type="text/javascript">
            $(function ($) {
                $(document).ready(function () {
                    $.ajaxSetup({cache: false});
                });
                $(document).keyup(function (e) {
                    if (e.keyCode == 40) {
                        Move("down", "m");
                    }
                    if (e.keyCode == 38) { // up
                        Move("up", "m");
                    }
                    if (e.keyCode == 37) { //left
                        Move("left", "m");
                    }
                    if (e.keyCode == 39) { //right
                        Move("right", "m");
                    }
                });

                function long_polling2() {
                    $.getJSON('/secured/MultiProgress', function (data) {
                        $('.progressBar').width(data.progress).text(data.progress + '%');
                        if (data.progress < 100)
                        {
                            long_polling2();
                        } else {
                                generate_Game(data.Maze, <%=session.getAttribute("Size")%>, data.Start_i.toString(), data.Start_j.toString(), data.End_i.toString(), data.End_j.toString(), "<%=u.icon%>");
                            // generate_table(data.Maze, <%=session.getAttribute("Size")%>, data.Start_i.toString(), data.Start_j.toString(), data.End_i.toString(), data.End_j.toString(), "<%=u.icon%>")
                            $('.progressBar').hide();

                            //window.location=window.location;
                            UpdateMove();
                        }
                    });
                }
                long_polling2();
            });
    </script>
</body>
</html>