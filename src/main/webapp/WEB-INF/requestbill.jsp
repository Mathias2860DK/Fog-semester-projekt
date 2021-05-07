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

       <p>Navn: ${sessionScope.deliveryInfo.name} </p>
       <p>Email: ${sessionScope.deliveryInfo.email} </p>
       <p>Adresse: ${sessionScope.deliveryInfo.address} </p>
       <p>Phone: ${sessionScope.deliveryInfo.phone} </p>
       <p>Postnummer og by: ${sessionScope.deliveryInfo.zipCodeCity} </p>
       <p>Bemærkninger: ${sessionScope.deliveryInfo.remarks} </p>

        <h3>Her er dine ønskede carportmål og materialer:</h3>

<p>Carportens højde: ${sessionScope.carport.carportHeight}</p>
<p>Carportens bredde: ${sessionScope.carport.carportWidth}</p>
        <!--Noget redskabsskur eller ej? evt jsp if statement -->
        <form action="${pageContext.request.contextPath}/fc/requestreceiptpage" method="POST">
            <button class="btn btn-primary" type="submit" value="bekræft">Bekræft</button>
        </form>

    </jsp:body>
</t:genericpage>