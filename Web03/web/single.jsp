<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body>
        <h1>Starting</h1>
        <div>Progress:</div>
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
    </body></html>