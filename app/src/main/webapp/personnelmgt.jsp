<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Personnel</title>
    </head>

    <body>
        <h2>Manage Personnel</h2>
        <form action="/addPersonnelView">
            <button type="submit">Add Person</button>
        </form>
        <hr/>
        <br>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Barangay</th>
                    <th>City</th>
                    <th>Birthday</th>
                    <th>GWA</th>
                    <th>Date Hired</th>
                    <th>Contact</th>
                    <th>Roles</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${personnelList}" var = "p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name.fname}</td>
                        <td>${p.name.mname}</td>
                        <td>${p.name.lname}</td>
                        <td>${p.address.brgy}</td>
                        <td>${p.address.city}</td>
                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${p.birthday}" /></td>
                        <td>${p.gwa}</td>
                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${p.dateHired}" /></td>
                        <td><a href = "/contactmgt?personnelId=<c:out value='${p.id}'/>" >View Contact</a></td>
                        <td><a href = "">View Roles</a></td>
                        <td><a href = "">Update Person</a></td>
                        <td><a href = "">Delete Person</a></td>
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