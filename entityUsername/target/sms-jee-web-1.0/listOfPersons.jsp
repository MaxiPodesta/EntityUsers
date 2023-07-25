<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- Allow to iterate each element of the list of persons -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Players</title>
    </head>
    <body>
        <h1>Players</h1>
        <ul>
            <c:forEach items="${persons}" var="person"><!<!-- Recovering the list of persons using the variable of person shared in the scope of request in the Servlet -->
                <li>${person.name} ${person.surname} ${person.email} ${person.phone}</li>  
            </c:forEach>
        </ul>
    </body>
</html>
