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
        <div>
        <div class="container min-vh-100">
            <div class="row">
                <section class="col-12">

                    <div class="row" id="invoice">
                        <article role="article" class="col mt-5">

                            <h2> VELKOMMEN I FOG</h2>
                            <p>
                                Her får du kvalificeret rådgivning til den bedste løsning. Fog hjælper dig med at få overblik og komme i mål med dit byggeprojekt.
                                Lige fra hvad der er godt at vide til vejledning i valg af materialer.
                                Johannes Fog består af et Bolig & Designhus og ni Trælast & Byggecenter-butikker fordelt i hele Nordsjælland – i Hørsholm, Fredensborg, Kvistgård, Helsinge, Lyngby, Ølstykke, Herlev og Farum.
                                Vi har også en butik mere sydpå i Vordingborg, der også har stor ekspertise i salg af jern, stål og andre metaller.

                                <br/>
                            <h5>DESIGN DIN EGEN CARPORT</h5>
                            I trælasten har vi træ og byggematerialer til alle slags opgaver.
                            Vi har et stort udvalg, hvor du kan vælge mellem mange muligheder, både hvad angår størrelser og kvaliteter.
                            <br/>
                            <br/>
                            <p>
                            Byggecentrene har alt til hjemmet inden for bl.a. værktøj, maling, bad, beslag, el, lamper og pejseartikler.
                            Fog kan hjælpe dig med valget af f.eks. en ny græsslåmaskine.
                            Der er power til forskel, men det handler om at vælge værktøjet til lige præcis dit behov.
                            Ordentlige haveredskaber og -møbler kan holde i rigtig mange år. Hos Fog får du kvalitet.
                            Her er der forskellige slags havemøbler at vælge i mellem, parasoller der bare holder, terrassevarmere og meget andet, der bidrager til det hyggelige udeliv.
                            Få kvalificeret rådgivning i Fog, så du nemt kan vælge.
                            </p>
                            <br>
                        </article>
                        <section class="col mt-5">
                            <div
                                    id="carouselExampleControls"
                                    class="carousel slide"
                                    data-ride="carousel"
                            >
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img
                                                class="d-block w-100"
                                                src="${pageContext.request.contextPath}/css/images/carportPic2.png"
                                                alt="First slide"
                                        />
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100"
                                             src="${pageContext.request.contextPath}/css/images/carportPicOne.png"
                                             alt="Second slide"
                                        />
                                    </div>
                                    <div class="carousel-item">
                                        <img
                                                class="d-block w-100"
                                                src="${pageContext.request.contextPath}/css/images/fogLogoOne.png"
                                                alt="Third slide"
                                        />
                                    </div>
                                </div>
                                <a
                                        class="carousel-control-prev"
                                        href="#carouselExampleControls"
                                        role="button"
                                        data-bs-slide="prev"
                                >
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Forrige</span>
                                </a>
                                <a
                                        class="carousel-control-next"
                                        href="#carouselExampleControls"
                                        role="button"
                                        data-bs-slide="next"
                                >
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Næste</span>
                                </a>
                            </div>

                        </section>
                    </div>
                </section>
                <div class="row">
                    <section style="margin-top: 10px" class="col-12 text-center">

                        <form action="${pageContext.request.contextPath}/fc/redirect">
                            <input type="submit" class="btn btn-primary" name="designcarport"
                                   value="Design din egen carport">
                        </form>
                    </section>
                </div>
            </div>
        </div>


    </jsp:body>
</t:genericpage>