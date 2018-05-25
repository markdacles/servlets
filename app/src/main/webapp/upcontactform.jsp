<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Update Contact</title>
    </head>

    <body>
        <h2>Update Contact</h2>
        <hr/>
        <div>
        <form action = "/updateContact" method = "POST">
            
            Landline:
                <input type = "text" name = "landline"><br/> 
            Mobile:
                <input type = "text" name = "mobile" maxlength="20"/><br/>
            Email:
                <input type = "email" name = "email" maxlength="20"/><br/>
                <br>
            <input type = "submit" value = "Update Contact" />
            <input type = "hidden" name = "personnelid" value = "${personnelid}"><br/> 
            <input type = "hidden" name = "contactid" value = "${contactid}"><br/> 
        </form>
        </div>
        <br>
         <a href="/contactmgt?personnelId=<c:out value='${personnelid}'/>">
           <input type="button" value="Back" />
        </a>
    </body>
</html>