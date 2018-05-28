<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Contact</title>
    </head>

    <body>
        <h2>Manage Contact for Personnel #${personnel.id}</h2>
        <hr/>
        <a href="addContact?personnelid=<c:out value='${personnel.id}'/>">
           <input type="button" value="Add Contacts" />
        </a>
        <br>
        <br>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th><a href = "/contactmgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='id'/>" >ID</a></th>
                    <th><a href = "/contactmgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='landline'/>" >Landline</a></th>
                    <th><a href = "/contactmgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='mobile'/>" >Mobile</a></th>
                    <th><a href = "/contactmgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='email'/>" >Email</a></th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${contact}" var = "contact">
                    <tr>
                        <td>${contact.contactId}</td>
                        <td>${contact.landline}</td>
                        <td>${contact.mobile}</td>
                        <td>${contact.email}</td>
                        <td>
                            <a href="updateContact?personnelid=<c:out value='${personnel.id}'/>&contactid=<c:out value='${contact.contactId}'/>">
                               Update Contact
                            </a>
                        </td>
                        <td valign="bottom">
                            <form name="${contact}" action="/deleteContact?personnelid=<c:out value='${personnel.id}'/>&contactid=<c:out value='${contact.contactId}'/>" method="POST">
                                <a href="javascript:document.forms['${contact}'].submit()">Delete Contact</a>
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