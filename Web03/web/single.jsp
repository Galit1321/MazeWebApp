<%-- 
    Document   : single
    Created on : 24/05/2016, 13:35:38
    Author     : גליתונופר
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Starting</h1>
        <div>Progress:</div>
        <a href="http://www.animatedimages.org/cat-flowers-50.htm"><img src="http://www.animatedimages.org/data/media/50/animated-flower-image-0005.gif" 
                                                                        border="0" alt="animated-flower-image-0005"/></a>
        <a href="http://www.animatedimages.org/cat-flowers-50.htm">
            <img src="http://www.animatedimages.org/data/media/50/animated-flower-image-0120.gif" border="0" alt="animated-flower-image-0120"/></a>
        <a href="http://www.animatedimages.org/cat-flowers-50.htm"><img src="http://www.animatedimages.org/data/media/50/animated-flower-image-0309.gif" border="0" alt="animated-flower-image-0309"/></a>
        <a href="http://www.animatedimages.org/cat-flowers-50.htm"><img src="http://www.animatedimages.org/data/media/50/animated-flower-image-0052.gif" border="0" alt="animated-flower-image-0052"/></a>
        <a href="http://www.animatedimages.org/cat-flowers-50.htm"><img src="http://www.animatedimages.org/data/media/50/animated-flower-image-0360.gif" border="0" alt="animated-flower-image-0360"/></a>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar"
                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
                40%
            </div>
        </div>
        <div class="progressBar" style="background-color:green;width:0px">0%</div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(function ($) {
                function long_polling() {
                    $.getJSON('Progress', function (data) {
                        $('.progressBar').width(data.progress).text(data.progress + '%');
                        if (data.progress < 100)
                            long_polling();
                    });
                }
                long_polling();
            });
        </script>
    </body>
</html>
