<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<section id="news">

    <c:forEach var="newss" items="${newsShowAll}">
        <p>${newss.newsName}</p>
    </c:forEach>

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <c:out value="${News.newsName}"></c:out>
                <h2 class="section-title">якась новина</h2>
                <p>${News.newsName}</p>
            </div>
        </div>

        <c:forEach items="${newsShowAll}" var="News">
        <form action="/testUpdate" method="post">
        <div class="row one-news">

            <sec:authorize access="hasAnyRole('ADMIN')">

                <input type="hidden" name="newsId" value="${News.id}">
                <input type="text" name="newsName" value="${News.newsName}">
                <input type="text" name="newsText" value="${News.newsText}">
                <input type="submit" value="Редагувати">

            </sec:authorize>

            <div class="col-lg-4 col-md-6 col-sm-6">
                <img class="img_elastic"
                     src="https://pm1.narvii.com/6272/9d365bc33fab3821251cf1f9e093f7ca1bbf6fb3_hq.jpg" alt="">
            </div>
            <div class="col-lg-8 col-md-6 col-sm-6">
                <h1><a href="#">${News.newsName}</a></h1>
                <p>${News.newsText}</p>
                <button type="button" name="button"><a href="comments.html">Коментарі</a></button>
            </div>
                </form>
            </c:forEach>
        </div>
    </div>
    5
</section>
