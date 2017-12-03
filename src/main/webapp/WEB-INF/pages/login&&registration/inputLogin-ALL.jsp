
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%--<!DOCTYPE html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>Вхід у ваш акаунт</title>--%>

    <%--<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="${contextPath}/style/css/common.css" rel="stylesheet">--%>

    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>

<%--<body>--%>

<div class=img_elastic1" id="headerwrap">
    <%--Параметр action указывает на адрес страницы, на которую мы будем передавать наши данные.--%>
    <form method="POST" action="/login" class="form-signin">
        <%--<h2 class="form-heading">Вхід</h2>--%>

        <%--<div class="form-group ${error != null ? 'has-error' : ''}">--%>
            <%--<span>${message}</span>--%>
            <%--<input name="username" type="text" class="form-control" placeholder="Логін"--%>
                   <%--autofocus="true"/>--%>
            <%--<input name="password" type="password" class="form-control" placeholder="Пароль"/>--%>
            <%--<span>${error}</span>--%>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Увійти</button>--%>
            <%--<h4 class="text-center"><a href="${contextPath}/registration">Створити акаунт</a></h4>--%>
        <%--</div>--%>
            <c:if test="${param.error!=null}">
                sdadfws
            </c:if>
            <c:if test="${param.logout!=null}">
                sdadfws
            </c:if>
        <input type="text" name="username" >
        <input type="text" name="password" >
        <input type="submit" value="go" >

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/style/js/bootstrap.min.js"></script>
<%--</body>--%>
<%--</html>--%>