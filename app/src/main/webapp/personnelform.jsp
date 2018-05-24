<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Add Personnel</title>
    </head>

    <body>
        <h2>Add Personnel</h2>
        <hr/>
        <br>

        <form action = "/addPersonnel" method = "POST">
            First Name:
                <input type = "text" name = "fname" required><br/> 
            Middle Name:
                <input type = "text" name = "mname" maxlength="20" required/><br/>
            Last Name:
                <input type = "text" name = "lname" maxlength="20" required/><br/>
            Barangay:
                <input type = "text" name = "barangay" maxlength="20" required/><br/>
            City:
                <input type = "text" name = "city" maxlength="20" required/><br/>
            Birthday:
                <input type = "date" name = "birthday" required/><br/><br/>
            GWA:
                <input type = "number" min="1" max="5" step = "0.01" name = "gwa" required/><br/>
            Date Hired:
                <input type = "date" name = "date_hired" required/><br/><br/><br>
            Landline:
                 <input type = "text" name = "landline" required><br/> 
            Mobile:
                 <input type = "text" name = "mobile" required><br/> 
            Email:
                 <input type = "email" name = "email" required><br/><br>
            Roles:<br>
                <c:forEach items="${roleList}" var="r">
                    <input type="checkbox" name="checkedRoles" value="<c:out value='${r.roleId}'/>"/><c:out value="${r.role}"/><br/>
                </c:forEach>
<br/>

            <input type = "submit" value = "Add Person" />
        </form>
        <br>
         <form action="personnelmgt">
            <button type="submit">Back</button>
        </form>
    </body>
</html>