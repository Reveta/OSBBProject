
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=img_elastic1" id="headerwrap">
    <%--Параметр action указывает на адрес страницы, на которую мы будем передавать наши данные.--%>
    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-heading">Вхід</h2>

        <c:if test="${param.error!=null}">
            <p class="has-error">Логін або пароль ведені невірно</p>
        </c:if>

        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Логін" autofocus="true"/>

            <input name="password" type="password" class="form-control" placeholder="Пароль"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Увійти</button>

            <h4 class="text-center"><a href="/registration"><p class="black">Створити акаунт</p></a></h4>
        </div>

<input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>

    </form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/style/js/bootstrap.min.js"></script>