
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorHandle.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>NEWSscrapping</title>
    <link rel="icon" href="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.hpAk6TvGlnf0RPlpupwpkwHaHa%26pid%3DApi&f=1" type="image/x-icon">
    <link rel="stylesheet" href="./style.css" type="text/css"/>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Cairo:wght@300&family=Changa:wght@200&display=swap');
    </style> 
</head>
<body>
<div class="container">
        <form action="WebScrap" id="myUrl" method="GET">
            <input id="query" type="search" name="url" placeholder="URL Please..."><br>
            <button id="btn" type="submit"> 
                <strong> Extract</strong>
            </button>
        </form>
</div>
</body>
</html>


