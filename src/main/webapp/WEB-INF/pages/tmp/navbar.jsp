<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <!-- При зменшенні екрану, всі вкладки меню перетворюються в кнопку з випадаючим меню -->
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/"><i class="fa fa-circle"></i>SBB</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <sec:authorize access="isAnonymous()">
                    <li class="active"><a href="/login"> Увійти </a></li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('USER','ADMIN')">
                    <li class="active"><a href="/logout"> Вийти </a></li>
                </sec:authorize>

                <li><a href="#">Архів</a></li>

                <sec:authorize access="hasAnyRole('USER')">
                    <li><a href="/cabinet"><i class="fa fa-envelope-o" aria-hidden="true">Cabinet</i></a></li>
                </sec:authorize>


                <%--Значок голосування, який буде зявлятись, коли є нове голосування--%>
                <li><a href="/"></a></li>
            </ul>
        </div>
    </div>
</div>