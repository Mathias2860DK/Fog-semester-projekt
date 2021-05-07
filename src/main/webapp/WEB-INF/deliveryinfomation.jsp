<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>


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
            <input type="submit" name="submit_request" title="Send request" value="Send forespørgsel" class="">




        <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>
        </form>
        </div>


    </jsp:body>
</t:genericpage>