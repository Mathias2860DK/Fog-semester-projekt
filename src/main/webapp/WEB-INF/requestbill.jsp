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


        <h3>Her er dine ønskede carportmål og materialer:</h3>

<p></p>
<p>Carportens højde er fastsat til ${sessionScope.carport.carportHeightStart} cm i den ene ende og ${sessionScope.carport.carportHeightEnd} cm i den anden</p>
<p>Carportens bredde: ${sessionScope.carport.carportWidth} cm</p>
        <p>Carportens længde ${sessionScope.carport.carportLength} cm</p>
        <p>Tag type: ${sessionScope.carport.roof}</p>
        <p>Bemærkninger: ${sessionScope.deliveryInfo.remarks} </p>
        <!--Noget redskabsskur eller ej? evt jsp if statement -->
        <form action="${pageContext.request.contextPath}/fc/requestreceiptpage" method="POST">
            <button class="btn btn-primary" type="submit" value="bekræft">Bekræft</button>
        </form>

    </jsp:body>
</t:genericpage>