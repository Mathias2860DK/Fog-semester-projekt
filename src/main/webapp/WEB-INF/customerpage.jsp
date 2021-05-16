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

        <p>Her er alle ordrer:</p>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Dato For Forespørgsel</th>
                    <th>Pris</th>
                    <th>Status</th>
                </tr>
                </thead>
                <c:if test="${sessionScope.orderList == null}">
<p>Du har aldrig bestilt en carport hos os. Det er en skam.</p>
                </c:if>
                    <c:forEach var="ordre" items="${sessionScope.orderList}">
                        <tbody>


                        <tr>

                            <td class="text-center">
                                <form name="customerorder" action="${pageContext.request.contextPath}/fc/showcustomerorder"  method="POST">
                                <button name="customerorder" class="btn btn-primary" type="submit" value="${ordre.orderId}">${ordre.orderId}</button>
                        </form>
                            </td>
                            <td class="text-center">${ordre.date}</td>
                            <c:if test="${ordre.totalprice == 0}">
                                <td class="text-center">Forespørgsel under behandling</td>
                            </c:if>
                            <c:if test="${ordre.totalprice > 1}">
                                <td class="text-center">${ordre.totalprice} kr</td>
                            </c:if>

                            <td class="text-center">${ordre.status}</td>
                        </tr>
                        </tbody>

                    </c:forEach>

            </table>
        </div>


    </jsp:body>

</t:genericpage>

