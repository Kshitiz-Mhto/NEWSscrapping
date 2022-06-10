<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oops! Page Not Found</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Indie+Flower&display=swap');
            .container{
                width: 46%;
                height:130vh;
                margin:auto;   
            }
            div#img{
                text-align: center;
            }
            h1{
                font-family: 'Indie Flower';
                font-size: 52px;
            }
             a{  
                font-size: 25px;
                border: 1px lightblue solid;
                border-radius: 4px;
                box-shadow: .5px -1px 14px lightblue;
                text-decoration: none;
            }
            a:link{
                color:blue;
            }
            a:visited{
                color: blue;
            }
            a:hover{
                cursor: pointer;
                color:green;
            }
            </style>
    </head>
    <body>
        <div class ="container">
            <div id="img">
                <img src="404.png"><br>
            </div>
            <h1 style="text-align: center;">Sorry! Page Not Found</h1>
            <p style="text-align: center;">
                <a href="index.jsp">Home</a>
            </p>
        </div>
    </body>
</html>
