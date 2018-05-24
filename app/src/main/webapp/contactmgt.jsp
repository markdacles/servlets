<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Contact</title>
    </head>

    <body>
        <h2>Manage Contact for Personnel #${personnelId}</h2>
        <form action="/addContactView">
            <jsp:include page="/addContactView?flag=1&operation=1"/>
            <button type="submit">Add Contact</button>
        </form>
        <hr/>
        <br>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th>ID</th>
                    <th>Landline</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${personnel.contact}" var = "contact">
                    <tr>
                        <td>${contact.contactId}</td>
                        <td>${contact.landline}</td>
                        <td>${contact.mobile}</td>
                        <td>${contact.email}</td>
                        <td><a href = "">Update Contact</a></td>
                        <td><a href = "">Delete Contact</a></td>
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