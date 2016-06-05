<%@page import="objects.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Single Game</title>
        <script src="Maze.js"></script>
        <link  rel="stylesheet" type="text/css" href="Single.css">
    </head>
    <body  >
        <div >
            <% User u = (User) session.getAttribute("Curr");%>
                <div class="sqr">
                    <div>Name: <%=u.name%></div>
                    <div>Logo: <image src="<%=u.icon%>" width="50" height="50"/></div> 
                    <form action="../LogOutServlet" method="post" >
                    <button class="gsBtn" type="sumbit"  >LogOut </button>
                    </form>
                </div></div>


    <div class="Main">
        <button type="submit" class="BtnS" name="act"  title="Hint" onclick="Clue()"  > Hint </button>
        <button type="submit" class="BtnS" name="act" title="Restart" onclick="Reset()" > Restart </button>
        <button type="submit" class="BtnS" name="act" title="Back" onclick="Back()"> Back </button>
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
                        Move("down", "s");
                    }
                    if (e.keyCode == 38) { // up
                        Move("up", "s");
                    }
                    if (e.keyCode == 37) { //left
                        Move("left", "s");
                    }
                    if (e.keyCode == 39) { //right
                        Move("right", "s");
                    }
                });
                function long_polling() {
                    $.getJSON('/secured/LongPolling', function (data) {
                        $('.progressBar').width(data.progress).text(data.progress + '%');
                        if (data.progress < 100)
                        {
                            long_polling();
                        } else {
                            generate_table(data.Maze,<%=session.getAttribute("Size")%>, data.Start_i.toString(), data.Start_j.toString(), data.End_i.toString(), data.End_j.toString(), "<%=u.icon%>");
                            $('.progressBar').hide();
                        }
                    });
                }


                long_polling();
            });
    </script>
</body></html>