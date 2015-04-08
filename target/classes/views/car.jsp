<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Car Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Car
</h1>
 
<c:url var="addAction" value="/car/add" ></c:url>
 
<form:form action="${addAction}" commandName="car">
<table>
    <c:if test="${not empty car.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="year">
                <spring:message text="Year"/>
            </form:label>
        </td>
        <td>
            <form:input path="year" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty car.name}">
                <input type="submit"
                    value="<spring:message text="Edit Car"/>" />
            </c:if>
            <c:if test="${empty car.name}">
                <input type="submit"
                    value="<spring:message text="Add Car"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Car List</h3>
<c:if test="${!empty cars}">
    <table class="tg">
    <tr>
        <th width="80">Car ID</th>
        <th width="120">Car Name</th>
        <th width="120">Car Year</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.name}</td>
            <td>${car.year}</td>
            <td><a href="<c:url value='/car/edit/${car.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/car/remove/${car.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>