<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<style>

</style>

<section id="news">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <h2 class="section-title">Актуальні новини та оголошення</h2>
            </div>
        </div>


        <c:forEach items="${newsShowAll}" var="News">
            <div class="row one-news">

                <img class="col-lg-12 col-md-12 col-sm-12">
                <img height="300" width="1000"
                     class="img_elastic backscreen"
                     src="${News.backscreen}"
                     alt="${News.newsName}"
                >


                <div class="col-lg-4 col-md-4 col-sm-4">
                    <form action="/deleteNews">
                        <input type="hidden" name="id" value="${News.id}">
                        <input type="submit" value="X">
                    </form>
                    <h1><a href="/newsPage-${News.id}">${News.newsName}</a></h1>
                    <p>${News.newsTime}</p>
                    <p>Текст новини: ${News.newsShort}</p>
                    <p>Текст новини: ${News.newsText}</p>

                    <%@include file="outputNewsComment.jsp" %>

                </div>

                <div class="col-lg-4 col-md-4 col-sm-4">
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <%@include file="../editingNews/editingNews.jsp" %>
                    </sec:authorize>
                </div>

                </img>
            </div>
        </c:forEach>


    </div>
</section>
