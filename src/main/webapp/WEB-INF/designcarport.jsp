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
                    <form action="${pageContext.request.contextPath}/fc/customizecarport" method="post" class="ng-pristine ng-valid">
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
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                        <option value="720">720 cm</option>
                                        <option value="750">750 cm</option>
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
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                        <option value="720">720 cm</option>
                                        <option value="750">750 cm</option>
                                        <option value="780">780 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="rooftype/colors" for="rooftype_options">
                                        Tag
                                    </label>
                                    <select class="form-control" id="rooftype_options" name="roof" title="rooftype/colors"><option selected="selected" value="">Vælg tagtype/farve</option>
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
                                    <select class="form-control" id="roof_pitch_options" name="roof_pitch" title="Roof pitch">
                                        <option value="15">15 grader</option>
                                        <option value="20">20 grader</option>
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
                                    <select class="form-control" id="toolroom-width" name="toolroom_width" title="Toolroom width"><option selected="selected" value="Ønsker ikke redskabsrum">Ønsker ikke redskabsrum</option>
                                        <option value="210">210 cm</option>
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                        <option value="720">720 cm</option>
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
                                        <option value="150">150 cm</option>
                                        <option value="180">180 cm</option>
                                        <option value="210">210 cm</option>
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
                                    <hr>
                                </div>

                                    <div class="col-md-6 col-xs-12">
                                        <c:if test="${requestScope.error != null}">
                                            <p style="color: red">${requestScope.error}</p>
                                        </c:if>
                                        <input type="submit" name="submit_request" title="Send request" value="Send forespørgsel" class="">
                                        <input type="submit" name="show_drawing" title="show drawing" value="Vis tegning" class="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">

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
                <a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>