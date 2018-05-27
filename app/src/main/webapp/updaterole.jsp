<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Update Role</title>
    </head>

    <body>
        <h2>Update Role</h2>
        <hr/>
        <br>

        <form action = "/updateRole" method = "POST">
            Role Name:
                <input type = "text" name = "role" value = "${r.role}" required><br/> 

                <br>
            <input type = "hidden" name = "roleid" value = "${roleid}"><br/> 

            <input type = "submit" value = "Update Role" />
        </form>

         <form action="rolemgt">
            <button type="submit">Back</button>
        </form>
    </body>
</html>