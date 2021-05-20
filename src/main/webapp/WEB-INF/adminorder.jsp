<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="col-xs-1 text-center" style="margin-bottom: 45px">
            <h1 class="display-4">Ordre #${sessionScope.order.orderId}</h1>
        </div>
        <c:if test="${requestScope.sucess != null }">
            <div class="col-md-12 text-center">
                <h2 style="color:green">
                        ${requestScope.sucess}
                </h2>
            </div>
        </c:if>
        <c:if test="${requestScope.error != null }">
            <div class="col-md-12 text-center">
                <h2 style="color:red">
                        ${requestScope.error}
                </h2>
            </div>
        </c:if>

        <div class="col-lg-12">
            <!-- col-lg-12 start here -->
            <div>
                <div>
                    <ul class="list-unstyled">
                        <!--no break points-->
                        <li><strong>Forespørgsel</strong> ${sessionScope.order.orderId}</li>
                        <li>
                            <strong>Dato for oprettelse af forespørgsel</strong>
                                ${sessionScope.order.date}
                        </li>

                        <li>
                            <strong>Status:</strong>
                            <span class="text-succes">${sessionScope.order.status}</span>
                        </li>
                    </ul>
                </div>
            </div>
            <div>
                <ul class="list-unstyled">
                    <li><strong>Oplysninger</strong></li>
                    <li>ID: ${sessionScope.order.orderId}</li>
                    <li>Dato: ${sessionScope.order.date}</li>
                    <li>Status: ${sessionScope.order.status}</li>
                    <li>Nuværende pris på ordre: ${sessionScope.order.totalprice}</li>
                    <li>Email: ${sessionScope.order.email}</li>
                </ul>
            </div>

            <div>
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
                        <c:if test="${sessionScope.carport.shed != null}">
                            <tr>
                                <td>Redskabsskur længde:</td>
                                <td class="text-center">${sessionScope.carport.shed.shedLength} cm</td>
                            </tr>
                            <tr>
                                <td>Redskabsskur bredde:</td>
                                <td class="text-center"><p>${sessionScope.carport.shed.shedWidth} cm</p></td>
                            </tr>
                        </c:if>

                        </tbody>
                    </table>
                </div>
            </div>
            <div>
                <p class="text-center">
                </p>
            </div>
        </div>
        <!-- col-lg-12 end here -->
        </div>
        <!-- End .row -->
        </div>
        </div>
        <!-- End .panel -->
        </div>
        <!-- col-lg-12 end here -->
        </div>
        </div>


        <div class="col-xs-1 text-center" style="margin-bottom: 45px">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Kostpris</th>
                        <th>Anbefalet pris</th>
                        <th>Nuværende pris</th>
                        <th>Nuværende dækningsgrad</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td> ${sessionScope.carport.costPrice} kr.</td>
                        <td class="text-center">${sessionScope.carport.recommendedPrice} kr.</td>
                        <td class="text-center">${sessionScope.order.totalprice} kr.</td>
                        <td class="text-center">${sessionScope.contributionRatio} %</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <c:if test="${sessionScope.order.status != 'paid'}">
                <form action="${pageContext.request.contextPath}/fc/updatecarportprice" method="post"
                      class="ng-pristine ng-valid">
                    <div class="form-group">
                        <label>Salgspris kr.</label>
                        <input name="salesprice" type="text" class="form-control" value="${sessionScope.salesprice}">
                    </div>

                    <button style="margin-top: 25px" type="submit" class="btn btn-danger" name="salesprice">Opdater
                        salgspris
                    </button>
                </form>
            </c:if>
        </div>

        <div class="col-md-12 text-center">
            <form action="${pageContext.request.contextPath}/fc/sendOfferToCustomer" method="post"
                  class="ng-pristine ng-valid">
                <c:if test="${sessionScope.order.status == 'offer sent' || sessionScope.order.status == 'request'}">
                    <button style="margin-right: 40px" type="submit" class="btn btn-success" name="sendOfferToId"
                            value="${sessionScope.order.orderId}">Send tilbud til kunden
                    </button>
                </c:if>

                <c:if test="${sessionScope.order.status == 'offer sent' || sessionScope.order.status == 'accepted'}">
                    <button type="submit" class="btn btn-success" name="statusPaid"
                            value="${sessionScope.order.orderId}">
                        Markér ordren som betalt
                    </button>
                </c:if>
            </form>


            <form action="${pageContext.request.contextPath}/fc/showBomAdminOrder" method="post"
                  class="ng-pristine ng-valid">
                <button style="margin-top: 25px" type="submit" class="btn btn-info" name="bomByOrderId"
                        value="${sessionScope.order.orderId}">Se stykliste
                </button>
            </form>
        </div>
        <c:if test="${requestScope.bomByOrderId != null }">
            <div>
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Beskrivelse</th>
                            <th>Længde</th>
                            <th>Antal</th>
                            <th>Enhed</th>
                            <th>Beskrivelse af brug</th>
                        </tr>
                        </thead>
                        <c:forEach var="material" items="${sessionScope.carport.materialList}">
                            <c:if test="${material.amount != 0 }">
                                <tbody>
                                <tr>
                                    <c:if test="${material.height != 0 && material.width != 0 }">
                                        <td class="text-center">${material.height}x${material.width} ${material.materialType}</td>
                                    </c:if>
                                    <c:if test="${material.height != 0 && material.width == 0 }">
                                        <td class="text-center">${material.height} ${material.materialType}</td>
                                    </c:if>
                                    <c:if test="${material.height == 0 && material.width != 0 }">
                                        <td class="text-center">${material.width} ${material.materialType}</td>
                                    </c:if>
                                    <c:if test="${material.height == 0 && material.width == 0 }">
                                        <td class="text-center">${material.materialType}</td>
                                    </c:if>

                                    <c:if test="${material.length != 0 }">
                                        <td class="text-center">${material.length}</td>
                                    </c:if>
                                    <c:if test="${material.length == 0 }">
                                        <td class="text-center"></td>
                                    </c:if>

                                    <td class="text-center">${material.amount}</td>
                                    <td class="text-center">${material.unit}</td>
                                    <td class="text-center">${material.description}</td>
                                </tr>
                                </tbody>
                            </c:if>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </c:if>


    </jsp:body>
</t:genericpage>
