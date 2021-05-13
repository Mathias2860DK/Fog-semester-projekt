<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <p>Her er alle matrialer:</p>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Matriale ID</th>
                    <th>Beskrivelse af brug</th>
                    <th>Beskrivelse af matriale</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>
                    <th>Enhed</th>
                    <th>Pris</th>
                </tr>
                </thead>
                <c:forEach var="material" items="${requestScope.materialList}">
                    <tbody>
                    <tr>
                        <td class="text-center">${material.materialId}</td>
                        <td class="text-center">${material.description}</td>
                        <td class="text-center">${material.materialType}</td>
                        <td class="text-center">${material.length}</td>
                        <td class="text-center">${material.width}</td>
                        <td class="text-center">${material.height}</td>
                        <td class="text-center">${material.unit}</td>
                        <td class="text-center">${material.price}</td>
                    </tr>
                    </tbody>

                </c:forEach>
            </table>
        </div>

    </jsp:body>
</t:genericpage>