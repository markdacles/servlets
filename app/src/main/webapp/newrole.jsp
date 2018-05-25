<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Add Role</title>
    </head>

    <body>
        <h2>Add Role</h2>
        <hr/>
        <div>   
        <form action = "/addRole" method = "POST">
            New Role:
                <input type = "text" pattern="[a-zA-Z]" name = "role" required><br/> 

            <input type = "submit" value = "Add Role" />
        </form>
    </div>
        <br>
        <a href="/rolemgt">
           <input type="button" value="Back" />
        </a>
    </body>
</html>