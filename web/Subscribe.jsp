<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subsribe page</title>
       <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
        <script src="Subscribe.js"></script>
        <link  rel="stylesheet" type="text/css" href="loginStyle.css">
    </head>
   
    <body>
       
        <h1>Hello World!</h1>
        <div class="Main">
            <form action="MyFormServlet" method="get">
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
                        <input type="Checkbox" name="myCheck" /><div> <image  src="groom4.png" alt="groom" name="icon" width="42" height="42"/></div>
                        
                    </div>   
                    <div>
                        <input type="Checkbox" name="myCheck" />
                         <image  src="groom4.png" alt="groom" name="icon" width="42" height="42"/>
                    </div>
                    <button type="submit" class="bnt" name="act" value="Done">Done</button>
                    <button type="reset"  class="bnt" value="Reset">Reset</button>
                </div>

            </form>
        </div>
    </body>
</html>
