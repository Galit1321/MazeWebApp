<%-- 
    Document   : GameLounge
    Created on : 30/05/2016, 01:35:05
    Author     : גליתונופר
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Lounge</title>
        <link  rel="stylesheet" type="text/css" href="GameLounge.css">
    </head>
    <body>
        <form action="GameLounge" method="post">
            <div class="st">
                <div>Game Name:
                    <div>
                        <input type="text" class="btn1" width="150px" name="act" />
                    </div>
                </div>
               
                <button type="sumbit" name="bnt" class="btn1" value="Send" title="Send">Send</button>
            </div>
        </form>


    </body>
</html>