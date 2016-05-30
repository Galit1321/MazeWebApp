<%@page import="objects.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Single Game</title>
        <script src="Maze.js"></script>
        <link  rel="stylesheet" type="text/css" href="Single.css">
    </head>
    <body >
        <div >
            <% User u = (User) session.getAttribute("Curr");%>
            <form action="Close" method="post" >
                <div class="sqr">
                    <div>Name: <%=u.name%></div>
                    <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div>   
                    <button class="bnt" type="sumbit"  >LogOut </button>
                </div></div>
    </form>


    <div class="Main">
        <button type="submit" class="BtnS" name="act"  title="Hint" onclick="Clue()"  > Hint </button>
        <button type="submit" class="BtnS" name="act" title="Restart"> Restart </button>
        <button type="submit" class="BtnS" name="act" title="Back"> Back </button>
        <div class="progressBar" style="background-color:green;width:0px">0%</div>
    </div>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function ($) {
            $(document).ready(function () {
                $.ajaxSetup({cache: false});
            });
            $(document).keyup(function (e) {
                if (e.keyCode == 40) {
                    Move("down");
                }
                if (e.keyCode == 38) { // up
                    Move("up");
                }
                if (e.keyCode == 37) { //left
                    Move("left");
                }
                if (e.keyCode == 39) { //right
                    Move("right");
                }
            });
            function long_polling() {
                $.getJSON('Progress', function (data) {
                    $('.progressBar').width(data.progress).text(data.progress + '%');
                    if (data.progress < 100)
                    {
                        long_polling();
                    } else {

                        generate_table(data.Maze, 13, data.Start_i.toString(), data.Start_j.toString(), data.End_i.toString(), data.End_j.toString(), "<%=u.icon%>");
                        $('.progressBar').hide();

                    }
                });
            }
            long_polling();
        });
    </script>
</body></html>