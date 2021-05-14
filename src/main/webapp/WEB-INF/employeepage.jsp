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
        You are now logged in as a EMPLOYEE of our wonderful FOG site.

        <form action="${pageContext.request.contextPath}/fc/employeepage" method="POST">>
            <label for="status"> Choose status for orders </label>
            <select name="sortBy" id="status">
                <option value="all orders">Alle ordre</option>
                <option value="request">Request</option>
                <option value="offer sent">Offer sent</option>
                <option value="accepted">Accepted</option>
                <option value="paid">Paid</option>
                <option value="declined">Declined</option>
                <option value="finished">Finished</option>
            </select>
            <br><br>
            <input type="submit" value="Submit">
        </form>

        <p>Her er alle ordrer:</p>
        <div class="table-responsive">
        <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Dato</th>
            <th>E-mail</th>
            <th>Pris</th>
            <th>Status</th>
        </tr>
        </thead>
        <c:forEach var="ordre" items="${requestScope.orderList}">
            <tbody>
            <tr>
                <td class="text-center">${ordre.orderId}</td>
                <td class="text-center">${ordre.date}</td>
                <td class="text-center">${ordre.deliveryInfoId}</td>
                <td class="text-center">${ordre.totalprice}</td>
                <td class="text-center">${ordre.status}</td>
            </tr>
            </tbody>

        </c:forEach>
        </table>
        </div>

    </jsp:body>
</t:genericpage>
