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

        <p>Her er alle kunder:</p>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Navn</th>
                    <th>Adresse</th>
                    <th>E-mail</th>
                    <th>Telefon</th>
                </tr>
                </thead>
                <c:forEach var="customer" items="${requestScope.getAllCustomers}">
                    <tbody>
                    <tr>
                        <td class="text-center">${customer.userId}</td>
                        <td class="text-center">${customer.name}</td>
                        <td class="text-center">${customer.address}</td>
                        <td class="text-center">${customer.email}</td>
                        <td class="text-center">${customer.phone}</td>
                    </tr>
                    </tbody>

                </c:forEach>
            </table>
        </div>

    </jsp:body>
</t:genericpage>