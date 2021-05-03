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

        <div class="formbuilder-block">
            <div class="row">
                <div class="col-md-12">
                    <form action="..." method="post" class="ng-pristine ng-valid">
                        <div id="table" class="form-horizontal col-md-12 col-xs-12">
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
            <span>
            Ønsket carport mål:
            </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="Carport bredde" for="Input_864110810">
                                        Carport bredde
                                    </label>
                                    <select class="form-control" name="carport_width" title="carport width"><option selected="selected" value="">Vælg bredde</option>
                                        <option value="240 cm">240 cm</option>
                                        <option value="270 cm">270 cm</option>
                                        <option value="300 cm">300 cm</option>
                                        <option value="330 cm">330 cm</option>
                                        <option value="360 cm">360 cm</option>
                                        <option value="390 cm">390 cm</option>
                                        <option value="420 cm">420 cm</option>
                                        <option value="450 cm">450 cm</option>
                                        <option value="480 cm">480 cm</option>
                                        <option value="510 cm">510 cm</option>
                                        <option value="540 cm">540 cm</option>
                                        <option value="570 cm">570 cm</option>
                                        <option value="600 cm">600 cm</option>
                                        <option value="630 cm">630 cm</option>
                                        <option value="660 cm">660 cm</option>
                                        <option value="690 cm">690 cm</option>
                                        <option value="720 cm">720 cm</option>
                                        <option value="750 cm">750 cm</option>
                                        <!--Skal hentes fra db -->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="carport length" for="carport_length_options">
                                        Carport længde
                                    </label>
                                    <select class="form-control" id="carport_length_options" name="carport_length" title="carport length"><option selected="selected" value="">Vælg længde</option>
                                        <option value="240 cm">240 cm</option>
                                        <option value="270 cm">270 cm</option>
                                        <option value="300 cm">300 cm</option>
                                        <option value="330 cm">330 cm</option>
                                        <option value="360 cm">360 cm</option>
                                        <option value="390 cm">390 cm</option>
                                        <option value="420 cm">420 cm</option>
                                        <option value="450 cm">450 cm</option>
                                        <option value="480 cm">480 cm</option>
                                        <option value="510 cm">510 cm</option>
                                        <option value="540 cm">540 cm</option>
                                        <option value="570 cm">570 cm</option>
                                        <option value="600 cm">600 cm</option>
                                        <option value="630 cm">630 cm</option>
                                        <option value="660 cm">660 cm</option>
                                        <option value="690 cm">690 cm</option>
                                        <option value="720 cm">720 cm</option>
                                        <option value="750 cm">750 cm</option>
                                        <option value="780 cm">780 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="rooftype/colors" for="rooftype_options">
                                        Tag
                                    </label>
                                    <select class="form-control" id="rooftype_options" name="Roof" title="rooftype/colors"><option selected="selected" value="">Vælg tagtype/farve</option>
                                        <option value="Betontagsten - Rød">Betontagsten - Rød</option>
                                        <option value="Betontagsten - Teglrød">Betontagsten - Teglrød</option>
                                        <option value="Betontagsten - Brun">Betontagsten - Brun</option>
                                        <option value="Betontagsten - Sort">Betontagsten - Sort</option>
                                        <option value="Eternittag B6 - Grå">Eternittag B6 - Grå</option>
                                        <option value="Eternittag B6 - Sort">Eternittag B6 - Sort</option>
                                        <option value="Eternittag B6 - Mokka (brun)">Eternittag B6 - Mokka (brun)</option>
                                        <option value="Eternittag B6 - Rødbrun">Eternittag B6 - Rødbrun</option>
                                        <option value="Eternittag B6 - Teglrød">Eternittag B6 - Teglrød</option>
                                        <option value="Eternittag B7 - Grå">Eternittag B7 - Grå</option>
                                        <option value="Eternittag B7 - Sort">Eternittag B7 - Sort</option>
                                        <option value="Eternittag B7 - Mokka (brun)">Eternittag B7 - Mokka (brun)</option>
                                        <option value="Eternittag B7 - Rødbrun">Eternittag B7 - Rødbrun</option>
                                        <option value="Eternittag B7 - Teglrød">Eternittag B7 - Teglrød</option>
                                        <option value="Eternittag B7 - Rødflammet">Eternittag B7 - Rødflammet</option>
                                    </select>
                                    <!--Skal hentes fra db -->
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="Roof pitch" for="roof_pitch_options">
                                        Taghældning
                                    </label>
                                    <select class="form-control" id="roof_pitch_options" name="RoofPitch" title="Roof pitch"><option value="15 grader">15 grader</option>
                                        <option value="20 grader">20 grader</option>
                                        <option selected="selected" value="25 grader">25 grader</option>
                                        <option value="30 grader">30 grader</option>
                                        <option value="35 grader">35 grader</option>
                                        <option value="40 grader">40 grader</option>
                                        <option value="45 grader">45 grader</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
            <span>
            <b>
            Redskabsrum:
            </b>
            <br>
            NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*
            </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="Toolroom width" for="toolroom-width">
                                        Redskabsrum bredde
                                    </label>
                                    <select class="form-control" id="toolroom-width" name="toolroom-width" title="Toolroom width"><option selected="selected" value="Ønsker ikke redskabsrum">Ønsker ikke redskabsrum</option>
                                        <option value="210 cm">210 cm</option>
                                        <option value="240 cm">240 cm</option>
                                        <option value="270 cm">270 cm</option>
                                        <option value="300 cm">300 cm</option>
                                        <option value="330 cm">330 cm</option>
                                        <option value="360 cm">360 cm</option>
                                        <option value="390 cm">390 cm</option>
                                        <option value="420 cm">420 cm</option>
                                        <option value="450 cm">450 cm</option>
                                        <option value="480 cm">480 cm</option>
                                        <option value="510 cm">510 cm</option>
                                        <option value="540 cm">540 cm</option>
                                        <option value="570 cm">570 cm</option>
                                        <option value="600 cm">600 cm</option>
                                        <option value="630 cm">630 cm</option>
                                        <option value="660 cm">660 cm</option>
                                        <option value="690 cm">690 cm</option>
                                        <option value="720 cm">720 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="Toolroom length" for="toolroom-length">
                                        Redskabsrum længde
                                    </label>
                                    <select class="form-control" id="toolroom-length" name="" title="Toolroom length"><option selected="selected" value="Ønsker ikke redskabsrum">Ønsker ikke redskabsrum</option>
                                        <option value="150 cm">150 cm</option>
                                        <option value="180 cm">180 cm</option>
                                        <option value="210 cm">210 cm</option>
                                        <option value="240 cm">240 cm</option>
                                        <option value="270 cm">270 cm</option>
                                        <option value="300 cm">300 cm</option>
                                        <option value="330 cm">330 cm</option>
                                        <option value="360 cm">360 cm</option>
                                        <option value="390 cm">390 cm</option>
                                        <option value="420 cm">420 cm</option>
                                        <option value="450 cm">450 cm</option>
                                        <option value="480 cm">480 cm</option>
                                        <option value="510 cm">510 cm</option>
                                        <option value="540 cm">540 cm</option>
                                        <option value="570 cm">570 cm</option>
                                        <option value="600 cm">600 cm</option>
                                        <option value="630 cm">630 cm</option>
                                        <option value="660 cm">660 cm</option>
                                        <option value="690 cm">690 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
                                    <hr>
                                </div>
                            </div>
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

                                    <label title="Zip code and city" for="zip_code_and_city">
                                        Postnummer og by
                                    </label>
                                    <input class="form-control" id="zip_code_and_city" name="zip_code_and_city" size="20" type="text" value="">


                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">

                                    <label title="Mobile" for="mobile">
                                        Telefon
                                    </label>
                                    <input class="form-control" id="mobile" name="mobile" size="20" type="text" value="">


                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">

                                    <label title="E-mail adresse" for="email_adress">
                                        E-mail adresse
                                    </label>
                                    <input class="form-control" id="email_adress" name="email" size="20" type="text" value="">


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

                                    <div class="col-md-6 col-xs-12">
                                        <input type="submit" name="submit_request" title="Send request" value="Send forespørgsel" class="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">

                            </div>
                        </div>

                    </form>        </div>
            </div>
        </div>

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

        </div>

    </jsp:body>
</t:genericpage>