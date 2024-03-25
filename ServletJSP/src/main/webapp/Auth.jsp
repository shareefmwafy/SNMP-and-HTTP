<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <form action="Servlet" method="post">
            ID: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Submit">
        </form>
        <%
            String result = (String)request.getAttribute("result");
            if(result != null) {
                String resultClass = (result.equals("OK")) ? "ok" : "no";
        %>
            <div class="result <%= resultClass %>"><%= result %></div>
        <% } %>
    </div>
</body>
</html>
