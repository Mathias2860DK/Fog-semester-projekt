<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="col-xs-1 text-center"  style="margin-bottom: 45px">
            <h1 class="display-4">Odre oversigt</h1>
        </div>

        <div class="table-responsive">
        <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Dato</th>
            <th>E-mail</th>
            <th>Pris</th>
            <th><form action="${pageContext.request.contextPath}/fc/employeeorders" method="POST">
                <label>Status</label>
                <select name="sortBy" id="">
                    <option value="all orders" selected="all orders" >all orders</option>
                    <option value="request">Request</option>
                    <option value="offer sent">Offer sent</option>
                    <option value="accepted">Accepted</option>
                    <option value="paid">Paid</option>
                    <option value="declined">Declined</option>
                    <option value="finished">Finished</option>
                </select>
                <input type="submit" value="Submit">
                <!-- <button name="customerorder" class="btn btn-primary" type="submit" value="${ordre.orderId}">${ordre.orderId}</button>-->
            </form></th>
        </tr>
        </thead>
            <c:if test="${requestScope.sortedList != null}">


        <c:forEach var="ordre" items="${requestScope.sortedList}">
            <tbody>
            <tr>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/fc/showorderdetailsadmin"  method="POST">
                        <button name="customerorder" class="btn btn-primary" type="submit" value="${ordre.orderId}">${ordre.orderId}</button>
                        <input type="hidden" name="customerorder" value="${ordre.orderId}">
                    </form>
                </td>
                <td class="text-center">${ordre.date}</td>
                <td class="text-center">${ordre.deliveryInfoId}</td>
                <td class="text-center">${ordre.totalprice}</td>
                <td class="text-center">${ordre.status}</td>
            </tr>
            </tbody>

        </c:forEach>
            </c:if>
        </table>
        </div>

    </jsp:body>
</t:genericpage>
