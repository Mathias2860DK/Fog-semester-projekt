<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.order != null }">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Besrkivelse</th>
                        <th>Specifikationer</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Carport længde:</td>
                        <td class="text-center">${sessionScope.order.carport.carportLength} cm</td>
                    </tr>
                    <tr>
                        <td>Carport bredde:</td>
                        <td class="text-center">${sessionScope.order.carport.carportWidth} cm</td>
                    </tr>
                    <tr>
                        <td>Carport start højde:</td>
                        <td class="text-center">${sessionScope.order.carport.carportHeightStart} cm</td>
                    </tr>
                    <tr>
                        <td>Carport slut højde:</td>
                        <td class="text-center">${sessionScope.order.carport.carportHeightEnd} cm</td>
                    </tr>
                    <tr>
                        <td>Tag type:</td>
                        <td class="text-center">${sessionScope.order.carport.roof}</td>
                    </tr>
                    <c:if test="${sessionScope.order.carport.shed.shedWidth != 0}">
                        <tr>
                            <td>Redskabsskur længde:</td>
                            <td class="text-center">${sessionScope.order.carport.shed.shedLength} cm</td>
                        </tr>
                        <tr>
                            <td>Redskabsskur bredde:</td>
                            <td class="text-center"><p>${sessionScope.order.carport.shed.shedWidth} cm</p></td>
                        </tr>
                    </c:if>

                    </tbody>
                </table>
            </div>
            <div class="col-md-12 text-center">
                <form action="${pageContext.request.contextPath}/fc/showcustomerorder" method="POST">
                    <button name="delete-del-info-id" class="btn btn-danger" type="submit"
                            value="${sessionScope.order.deliveryInfoId}">Slet ordre
                    </button>
                    <c:if test="${requestScope.offerSent == 1}">
                        <button name="accept-del-info-id" class="btn btn-success" type="submit"
                                value="${sessionScope.order.deliveryInfoId}">Accepter tilbud
                        </button>
                    </c:if>
                </form>
            </div>
        </c:if>
        <c:if test="${requestScope.sucess != null }">
            <div class="col-md-12 text-center">
                <h2 style="color:green">
                        ${requestScope.sucess}
                </h2>
            </div>
        </c:if>

    </jsp:body>

</t:genericpage>

