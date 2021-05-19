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


            <h2>Her er den valgte kundes ordre:</h2>
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
                        <td class="text-center">${sessionScope.carport.costPrice*1.39} kr.</td>
                        <td class="text-center">${sessionScope.order.totalprice} kr.</td>
                        <td class="text-center">${sessionScope.contributionRatio} %</td>
                    </tr>
                    </tbody>
                </table>
            </div>


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
        </div>
        <div class="col-md-12 text-center">
            <form action="${pageContext.request.contextPath}/fc/sendOfferToCustomer" method="post"
                  class="ng-pristine ng-valid">
                <button style="margin-right: 40px" type="submit" class="btn btn-success" name="sendOfferToId"
                        value="${sessionScope.order.orderId}">Send tilbud til kunden
                </button>
                <button type="submit" class="btn btn-success" name="statusPaid" value="${sessionScope.order.orderId}">
                    Markér ordren som betalt
                </button>
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
                            <tbody>
                            <tr>
                                <td class="text-center">${material.height}x${material.width} ${material.materialType}</td>
                                <td class="text-center">${material.length}</td>
                                <td class="text-center">${material.amount}</td>
                                <td class="text-center">${material.unit}</td>
                                <td class="text-center">${material.description}</td>
                            </tr>
                            </tbody>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </c:if>


    </jsp:body>
</t:genericpage>
