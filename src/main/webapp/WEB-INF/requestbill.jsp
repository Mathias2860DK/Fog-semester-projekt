<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <h3>Du har givet os følgende leverings oplsyninger</h3>

       <p>Navn: ${requestScope.name} </p>
       <p>Email: ${requestScope.email} </p>
       <p>Adresse: ${requestScope.adress} </p>
       <p>Phone: ${requestScope.phone} </p>
       <p>Postnummer og by: ${requestScope.zip_code_city} </p>
       <p>Bemærkninger: ${requestScope.remarks} </p>

        <h3>Her er dine ønskede carportmål og materialer:</h3>

<p> height${sessionScope.carport.carportHeight}</p>
<p>width ${sessionScope.carport.carportWidth}</p>
        <form action="${pageContext.request.contextPath}/fc/requestreceiptpage" method="POST">
            <button class="btn btn-primary" type="submit" value="bekræft">Bekræft</button>
        </form>

    </jsp:body>
</t:genericpage>