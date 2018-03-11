<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<style>
</style>

<section id="news">
    <div>Новини</div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <h2 class="section-title">Актуальні новини та оголошення</h2>
            </div>
        </div>

        <div>Test
            <div>
                Ім'я останньої новини - ${newsLast.newsName}
            </div>
            <div>
                <c:forEach items="${newsListTree}" var="newsListTree">
                    <p>Name of newsListTree - ${newsListTree.newsName}</p>
                </c:forEach>
            </div>

        </div>


        <c:forEach items="${newsShowAll}" var="News">
            <div class="row one-news">

                <img class="col-lg-12 col-md-12 col-sm-12">
                <img height="100" width="1000"
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
                    <p>${News.newsTime} ${News.newsAuthor}</p>
                    <p>Текст новини: ${News.newsShort}</p>
                    <p>Текст новини: ${News.newsText}</p>


                </div>

                <div class="col-lg-4 col-md-4 col-sm-4">
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <%@include file="../editingNews/editingNews.jsp" %>
                    </sec:authorize>
                </div>

                <div class="col-lg-4 col-md-4 col-sm-4">
                    <%@include file="outputNewsComment.jsp" %>
                </div>

                </img>
            </div>
        </c:forEach>


    </div>
</section>