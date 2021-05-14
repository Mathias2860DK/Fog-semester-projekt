<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
    <link rel="icon"  type="image/png" sizes="16×16" href="css/images/fogLogo.png">
</head>
<body>

    <!--
        This header is inspired by this bootstrap
        example: https://getbootstrap.com/docs/5.0/examples/pricing/
    -->
    <div id="header-picture">
        <img class="img-fluid" src="${pageContext.request.contextPath}/css/images/test2.png">
    </div>
<header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 bg-white text-white">
    <div class="h5 my-0 me-md-auto fw-normal">

        <a class="logo navbar-brand ml-5" href="<%=request.getContextPath()%>" title="Logo">
            <img heigth="90" width="90" src="css/images/fogLogo.png" alt="Fog logo" >
        </a>
        <p style="$font-size: larger">
            <jsp:invoke fragment="header"/>
        </p>
    </div>
    <nav class="my-2 my-md-0 me-md-3 text-white">


        <c:if test="${addHomeLink == null }">
            <a class="text-white" href="<%=request.getContextPath()%>">Hjem</a>
        </c:if>



        <c:if test="${sessionScope.role == 'employee' }">
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/employeeorders">Ordre</a>
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/materialspage">Matrialer</a>
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/employeepage">Kunder</a>
        </c:if>
        <c:if test="${sessionScope.role == 'customer' }">
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/custommerorders">Mine ordre</a>
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/customerpage">Om fog</a>
            <a type="button" class="text-white"
               href="${pageContext.request.contextPath}/fc/customerpage">??</a>
        </c:if>
    </nav>

    <div>

        <c:if test="${sessionScope.user != null }">
            ${sessionScope.user.email}
        </c:if>

        <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
        <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
        <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

        <c:if test="${isNotLoginPage && isNotRegisterPage}">
            <c:if test="${sessionScope.user != null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary text-white"
                href="${pageContext.request.contextPath}/fc/logoutcommand">Log ud</a>
            </c:if>
            <c:if test="${sessionScope.user == null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary text-white"
                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary text-white"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
            </c:if>
    </div>
    </c:if>
</header>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>