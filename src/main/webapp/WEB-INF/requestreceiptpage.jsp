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
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                    <!-- col-lg-12 start here -->
                    <div class="panel">
                        <!-- Start .panel -->
                        <div>
                            <div class="row">
                                <!-- Start .row -->
                                <div class="col-lg-6">
                                    <!-- col-lg-6 start here -->
                                    <div class="fog-logo">
                                        <img
                                                width="100"
                                                src="olskercupcakesBillede.png"
                                                alt="fog-logo"
                                        />
                                    </div>
                                </div>
                                <!-- col-lg-6 end here -->
                                <div class="col-lg-6">
                                    <!-- col-lg-6 start here -->
                                    <div class="fog-credentials">
                                        <ul class="list-unstyled text-right">
                                            <li>Johannes Fog A/S</li>
                                            <li>Firskovvej 20</li>
                                            <li>2800 Lyngby</li>
                                            <li>CVR-nr. 16314439</li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- col-lg-6 end here -->
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <h2>Tak for din forespørgsel</h2>
                                    <p>Vi behandler din forespørgsel hurtigst muligt</p>
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
                                            <li>Navn: ${sessionScope.deliveryInfo.name}</li>
                                            <li>Adresse: ${sessionScope.deliveryInfo.address}</li>
                                            <li>Postnummer og by: ${sessionScope.deliveryInfo.zipCodeCity}</li>
                                            <li>Telefon: ${sessionScope.deliveryInfo.phone}</li>
                                            <li>E-mail: ${sessionScope.deliveryInfo.email}</li>
                                            <li>Bemærkninger:<c:if
                                                    test="${sessionScope.deliveryInfo.remarks != null}"> ${sessionScope.deliveryInfo.remarks}</c:if>
                                                <c:if test="${sessionScope.deliveryInfo.remarks == null || sessionScope.deliveryInfo.remarks == '' }">Ingen</c:if>
                                            </li>
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
                                                    <td class="text-center">${sessionScope.carport.carportLength} cm
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Carport bredde:</td>
                                                    <td class="text-center">${sessionScope.carport.carportWidth} cm</td>
                                                </tr>
                                                <tr>
                                                    <td>Carport start højde:</td>
                                                    <td class="text-center">${sessionScope.carport.carportHeightStart}
                                                        cm
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Carport slut højde:</td>
                                                    <td class="text-center">${sessionScope.carport.carportHeightEnd}
                                                        cm
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Tag type:</td>
                                                    <td class="text-center">${sessionScope.carport.roof}</td>
                                                </tr>
                                                <c:if test="${sessionScope.carport.shed != null}">
                                                    <tr>
                                                        <td>Redskabsskur længde:</td>
                                                        <td class="text-center">${sessionScope.carport.shed.shedLength}
                                                            cm
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Redskabsskur bredde:</td>
                                                        <td class="text-center">
                                                            <p>${sessionScope.carport.shed.shedWidth} cm</p></td>
                                                    </tr>
                                                </c:if>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="text-center">
                                            Hvis du har nogle spørgsmål så send os en mail
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
    </jsp:body>

</t:genericpage>

