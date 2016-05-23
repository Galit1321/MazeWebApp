<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subsribe page</title>
        <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
        <script src="Subscribe.js"></script>
        <link  rel="stylesheet" type="text/css" href="subscribe.css">
    </head>
    <body>
        <div class="Main">
            <form  id="subscribe" action="MyFormServlet" method="get">
                <div>Username:
                    <div>
                        <input class="Field" type="text" name="username" required  />
                    </div>
                </div>
                <div>Password:</div>
                <input class="Field" type="password" name="password" required />
                <div> First and Last Name<input  class="Field" type="text" name="name" required  /></div>
                <div> Email <input class="Field"  type="email" id="myEmail" name="mail" required /> </div>
                <div>Logo
                    <div >
                        <div>
                            <input type="Checkbox" name="myCheck"  value="pic/bee1.jpg" /><image  src="pic/bee1.jpg" name="icon" width="50" height="50"/>
                            <input type="Checkbox" name="myCheck" value="pic/bee2.jpg"/>
                            <image  src="pic/bee2.jpg" name="icon" width="50" height="50"/>
                            <input type="Checkbox" name="myCheck" value="pic/bee3.png" />
                            <image  src="pic/bee3.png" name="icon" width="50" height="50"/>
                        </div>
                        <div>
                            <input type="Checkbox" name="myCheck" value="pic/bird.png"/>
                            <image  src="pic/bird.png" name="icon" width="50" height="50"/>
                            <input type="Checkbox" name="myCheck" value="pic/bird2.png"/>
                            <image  src="pic/bird2.png" name="icon" width="50" height="50"/>  
                        </div>
                        <div>
                            <input type="Checkbox" name="myCheck" value="pic/butterfly.png"/>
                        <image  src="pic/butterfly.png" name="icon" width="50" height="50"/>
                            <input type="Checkbox" name="myCheck" value="pic/butterfly02.png"/>
                            <image  src="pic/butterfly02.png" name="icon" width="50" height="50"/>
                        </div>
                    </div>
                    <button type="submit" class="bnt" name="act" value="Done"  >Done</button>
                    <button type="reset"  class="bnt" value="Reset">Reset</button>
                </div>

            </form>
        </div>
    </body>
</html>
