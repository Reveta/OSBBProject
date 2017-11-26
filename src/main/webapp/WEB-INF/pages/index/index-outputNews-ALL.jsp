<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<section id="news">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <h2 class="section-title">Актуальні новини та оголошення</h2>
            </div>
        </div>

        <c:forEach items="${newsShowAll}" var="News">
            <form action="/testUpdate" method="post">
                <div class="row one-news">

                    <input type="hidden" name="newsId" value="${News.id}">
                    <input type="text" name="newsName" value="${News.newsName}">
                    <input type="submit" value="GO">



                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <img class="img_elastic"
                             src="https://pm1.narvii.com/6272/9d365bc33fab3821251cf1f9e093f7ca1bbf6fb3_hq.jpg" alt="">
                    </div>
                    <div class="col-lg-8 col-md-6 col-sm-6">
                        <h1><a href="#">${News.newsName}</a></h1>
                        <p>${News.newsText}</p>
                        <button type="button" name="button"><a href="comments.html">Коментарі</a></button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>
    </div>
</section>
