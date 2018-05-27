<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Personnel Roles</title>
    </head>

    <body>
        <h2>Manage Roles for Personnel #${personnel.id}</h2>
        <hr/>
        <a href="addProle?personnelid=<c:out value='${personnel.id}'/>">
           <input type="button" value="Add Role" />
        </a>
        <br>
        <br>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th>ID</th>
                    <th>Role Name</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${personnel.roles}" var = "roles">
                    <tr>
                        <td>${roles.roleId}</td>
                        <td>${roles.role}</td>
                        <td valign="bottom">
                            <form name="${roles}" action="/deleteProle?personnelid=<c:out value='${personnel.id}'/>&roleid=<c:out value='${roles.roleId}'/>" method="POST">
                                <a href="javascript:document.forms['${roles}'].submit()">Delete Role</a>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
         <form action="/personnelmgt">
            <button type="submit">Back</button>
        </form>
    </body>
</html>