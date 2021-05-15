<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        Role: ${sessionScope.role}

        <p>Caport bredde: ${requestScope.customerorder.carport.carportWidth}</p>
        <p>Carport længde:${requestScope.customerorder.carport.carportLength}</p>
        <p>Tag: ${requestScope.customerorder.carport.roof}</p>
        <p>${requestScope.customerorder.carport.carportWidth}</p>

    </jsp:body>

</t:genericpage>

