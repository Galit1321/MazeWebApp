<%@page import="objects.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Single Game</title>
         <script src="Maze.js"></script>
            <link  rel="stylesheet" type="text/css" href="Single.css">
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
            <button type="submit" class="BtnS" name="act" title="Hint"> Hint </button>
            <button type="submit" class="BtnS" name="act" title="Restart"> Restart </button>
            <button type="submit" class="BtnS" name="act" title="Back"> Back </button>
        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(function ($) {
                $(document).ready(function() {
                $.ajaxSetup({ cache: false });
                });
                function long_polling() {
                    $.getJSON('Progress', function (data) {
                        $('.progressBar').width(data.progress).text(data.progress + '%');
                        if (data.progress < 100)
                        { long_polling();}
                        else {
                          //generate_table(data.Maze, 13, data.Start_i,data.Start_j,data.End_i, data.End_j, "<%=u.icon%>");
                          generate_table(data.Maze, 13, 3,4,5, 1, "<%=u.icon%>");

                             $('.progressBar').hide();
                        }
                    });
                }
                long_polling();
            });
        </script>
    </body></html>