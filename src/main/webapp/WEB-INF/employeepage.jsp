<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <p>Her er alle ordrer:</p>
        <c:forEach var="ordre" items="${requestScope.orderList}">
            <p>Ordre ID: ${ordre.orderId}</p>
            <p>Ordre ID: ${ordre.deliveryInfoId}</p>
            <p>Ordre ID: ${ordre.carport.carportLength}</p>
            <p>Carport bredde: ${ordre.carport.carportWidth}</p>
            <p>Ordre ID: ${ordre.carport.shed.shedLength}</p>
            <p>Ordre ID: ${ordre.carport.shed.shedWidth}</p>
            <p>Ordre ID: ${ordre.carport.roof}</p>
            <p>Ordre ID: ${ordre.status}</p>
            <p>Ordre ID: ${ordre.date}</p>
            <p>Ordre ID: ${ordre.totalprice}</p>

        </c:forEach>


    </jsp:body>
</t:genericpage>
