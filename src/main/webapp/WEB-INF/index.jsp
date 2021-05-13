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

        <div class="container min-vh-100">
            <div class="row">
                <section class="col-12">

                    <div class="row" id="invoice">
                        <article role="article" class="col mt-5">


                            <h2>  consectetuer adipiscing elit</h2>
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
                            <div id="carouselExampleControls" class="carousel slide carousel-fade"
                                 data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleControls" data-slide-to="0"
                                        class="active"></li>
                                    <li data-target="#carouselExampleControls" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleControls" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img class="d-block w-100" src="${pageContext.request.contextPath}/css/images/fog-logo1.svg" alt="First slide">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Wilkommen</h5>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="${pageContext.request.contextPath}/css/images/ProductPage.png" alt="Second slide">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                            <p></p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="${pageContext.request.contextPath}/css/images/cupcakeShop.jpg" alt="Third slide">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                            <p></p>
                                        </div>
                                    </div>

                                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                                       data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                                       data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </section>
            </div>
        </div>
        <form action="fc/redirect">
            <input type="submit" class="btn btn-primary" name="designcarport" value="Design din egen carport">
        </form>




    </jsp:body>
</t:genericpage>