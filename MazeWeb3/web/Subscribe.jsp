

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subsribe page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="Main">
            <form action="MyFormServlet" method="get">
                <div>Username:
                    <div>
                        <input class="Field" type="text" name="username" />
                    </div>
                </div>
                 <div>Password:</div>
                <input class="Field" type="password" name="password" />
                <div> First and Last Name<input type="text" name="name" /></div>
                <div> Email <input <input type="email" id="myEmail" name="mail"/> </div>
                <div>Logo
                    <div >
                        <input type="Checkbox" id="myCheck" /><div> <image  src="groom4.png" alt="groom" width="42" height="42"/></div>
                    </div>
                        
                    </div>
            </form>
        </div>
    </body>
</html>
