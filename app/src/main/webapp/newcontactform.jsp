<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Add Contact</title>
    </head>

    <body>
        <h2>Add Contact</h2>
        <hr/>
        <div>   
        <form action = "/addContact?personnelid=<c:out value='${personnelid}'/>" method = "POST">
            Landline:
                <input type = "text" name = "landline" required><br/> 
            Mobile:
                <input type = "text" name = "mobile" maxlength="20" required/><br/>
            Email:
                <input type = "email" name = "email" maxlength="20" required/><br/>

            <input type = "submit" value = "Add Contact" />
        </form>
    </div>
        <br>
        <a href="/contactmgt?personnelId=<c:out value='${personnelid}'/>">
           <input type="button" value="Back" />
        </a>
    </body>
</html>