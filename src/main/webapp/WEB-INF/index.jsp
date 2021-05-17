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


                            <h2>  Velkommen til fog trælast</h2>
                            <p>
                                giat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum.
                                Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.
                                Nam eget dui. Etiam rhoncus. Maecenas tempus, tellu

                                <br/>
                            <h5> tempus, tellu </h5>
                            Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.
                            Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,
                            sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit v
                            <br/>
                            <br/>

                            <h5>Maecenas tempus, tellus eget </h5>
                            Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.
                            Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,
                            sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit v
                            </p>
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
                                                src="${pageContext.request.contextPath}/css/images/fogLogoOne.png"
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
                                                src="${pageContext.request.contextPath}/css/images/carportPic2.png"
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
                            <input type="submit" class="btn btn-primary" name="designcarport" value="Design din egen carport">
                        </form>
                        </section>
                </div>
            </div>
        </div>






    </jsp:body>
</t:genericpage>