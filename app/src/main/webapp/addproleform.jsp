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
        <form action = "/addProles?personnelid=<c:out value='${personnelid}'/>" method = "POST">
            Available Roles:<br>
                <c:forEach items="${aroles}" var="r">
                    <input type="checkbox" name="checkedRoles" value="<c:out value='${r.roleId}'/>"/><c:out value="${r.role}"/><br/>
                </c:forEach>

            <input type = "submit" value = "Add Roles" />
        </form>
    </div>
        <br>
        <a href="/proles?personnelId=<c:out value='${personnelid}'/>">
           <input type="button" value="Back" />
        </a>
    </body>
</html>