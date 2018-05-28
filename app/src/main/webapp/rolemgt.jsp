<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Roles</title>
    </head>

    <body>
        <h2>Manage Roles</h2>
         <hr/>
        <form action="newrole.jsp">
            <button type="submit">Add Roles</button>
        </form>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th><a href = "/rolemgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='id'/>" >ID</a></th>
                    <th><a href = "/rolemgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='role'/>" >Role Name</a></th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${sortedRoles}" var = "r">
                    <tr>
                        <td>${r.roleId}</td>
                        <td>${r.role}</td>
                        <td><a href = "/updateRole?roleid=<c:out value='${r.roleId}'/>" >Update Role</a></td>
                        <td>
                            <c:choose>
                             <c:when test="${fn:contains(activeRoles, r.role)}">
                                Active role
                             </c:when>
                             <c:otherwise>
                              <form name="${r}" action="/deleteRole?roleid=<c:out value='${r.roleId}'/>" method="POST">
                                <a href="javascript:document.forms['${r}'].submit()">Delete Role</a>
                            </form>
                             </c:otherwise>
                            </c:choose>
                           
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
         <form action="index.jsp">
            <button type="submit">Back</button>
        </form>
    </body>
</html>