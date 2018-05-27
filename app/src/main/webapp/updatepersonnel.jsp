<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Update Personnel</title>
    </head>

    <body>
        <h2>Update Personnel</h2>
        <hr/>
        <br>

        <form action = "/updatePersonnel" method = "POST">
            First Name:
                <input type = "text" name = "fname" value = "${p.name.fname}" required><br/> 
            Middle Name:
                <input type = "text" name = "mname" maxlength="20" value = "${p.name.mname}" required/><br/>
            Last Name:
                <input type = "text" name = "lname" maxlength="20" value = "${p.name.lname}" required/><br/>
            Barangay:
                <input type = "text" name = "barangay" maxlength="20" value = "${p.address.brgy}" required/><br/>
            City:
                <input type = "text" name = "city" maxlength="20" value = "${p.address.city}" required/><br/>
            Birthday:
                <input type = "date" name = "birthday" value = "${p.birthday}" required/><br/><br/>
            GWA:
                <input type = "number" min="1" max="5" step = "0.01" name = "gwa" value = "${p.gwa}" required/><br/>
            Date Hired:
                <input type = "date" name = "date_hired" value = "${p.dateHired}" required/>

                <br>
            <input type = "hidden" name = "personnelid" value = "${personnelid}"><br/> 

            <input type = "submit" value = "Update Person" />
        </form>

         <form action="personnelmgt">
            <button type="submit">Back</button>
        </form>
    </body>
</html>