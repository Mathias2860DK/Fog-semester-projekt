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
                    <li>Pris: ${sessionScope.order.totalprice}</li>
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
                                <td class="text-center"> <p>${sessionScope.carport.shed.shedWidth} cm</p></td>
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


            <p>Kostpris: Pris: ${sessionScope.order.totalprice}</p>
        <p>Anbefalet salgspris${sessionScope.order.totalprice*1.39}</p>

            <form action="${pageContext.request.contextPath}/fc/updatecarportprice" method="post" class="ng-pristine ng-valid">
                <div class="form-group">
                <label>Salgspris  ${sessionScope.salesprice} kr.</label>
                    <input name="salesprice" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-success" name="salesprice">Opdater salgspris</button>
            </form>

             <p>Dækingsgrad: ${sessionScope.contributionRatio} %</p>
        </div>

        <form action="${pageContext.request.contextPath}/fc/sendOfferToCustomer" method="post" class="ng-pristine ng-valid">
            <button type="submit" class="btn btn-primary" name="sendOfferToId" value="${sessionScope.order.orderId}">Send tilbud til kunden</button>
        </form>






    </jsp:body>
</t:genericpage>
