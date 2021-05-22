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
        <div class="col-xs-1 text-center" style="margin-bottom: 45px">
            <h1 class="display-4">Indtast dine oplysninger</h1>
        </div>

        </div>
        <form action="${pageContext.request.contextPath}/fc/requestbill" method="post" class="ng-pristine ng-valid">
            <div class="form-group">
                <div class="col-md-12 col-xs-12">

                    <label title="Navn" for="customer_name">
                        Navn
                    </label>
                    <input class="form-control" id="customer_name" name="name" size="20" type="text" value="">


                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12 col-xs-12">

                    <label title="Adress" for="adress">
                        Adresse
                    </label>
                    <input class="form-control" id="adress" name="adress" size="20" type="text" value="">


                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12 col-xs-12">

                    <label title="Zip code and city" for="zip_code_city">
                        Postnummer og by
                    </label>
                    <input class="form-control" id="zip_code_city" name="zip_code_city" size="20" type="text" value="">


                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12 col-xs-12">

                    <label title="Mobile" for="phone">
                        Telefon
                    </label>
                    <input class="form-control" id="phone" name="phone" size="20" type="text" value="">


                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12 col-xs-12">

                    <label title="E-mail adresse" for="email">
                        E-mail adresse
                    </label>
                    <input class="form-control" id="email" name="email" size="20" type="text" value="">


                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12 col-xs-12">


                    <label title="Evt. bemærkninger" for="remarks">
                        Evt. bemærkninger
                    </label>
                    <textarea class="form-control" cols="20" id="remarks" name="remarks" rows="2"></textarea>

                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 col-xs-12">
                    <input style="margin-top: 15px" type="submit" name="submit_request" title="Send request" value="Send forespørgsel" class="btn-primary">
                </div>
            </div>
        </form>
        </div>

        <c:if test="${sessionScope.oldDelivery != null}">
            <p style="margin-top: 40px">${sessionScope.oldDelivery}</p>

            <p>Navn: ${sessionScope.deliveryInfo.name}</p>
            <p>Email: ${sessionScope.deliveryInfo.email}</p>
            <p>Postnummer og by: ${sessionScope.deliveryInfo.zipCodeCity}</p>
            <p>Telefon: ${sessionScope.deliveryInfo.phone}</p>
            <p>Adresse: ${sessionScope.deliveryInfo.address}</p>

            <form action="${pageContext.request.contextPath}/fc/requestbill">
                <input style="margin-top: 15px" type="submit" class="btn btn-success" name="submitOldDelivery"
                       value="Send gamle leveringsoplysninger">
            </form>


        </c:if>


    </jsp:body>
</t:genericpage>