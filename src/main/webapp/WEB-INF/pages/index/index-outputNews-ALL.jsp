<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<section id="news">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <h2 class="section-title">Актуальні новини та оголошення</h2>
            </div>
        </div>

        <c:forEach items="${newsShowAll}" var="News">
            <div class="row one-news">
                <div class="col-lg-4 col-md-6 col-sm-6">

                    <div class="img_elastic newsfhoto" src="" alt=""></div>
                </div>
                <div class="col-lg-8 col-md-6 col-sm-6">
                    <h1><a href="#">${News.newsName}</a></h1>
                    <p>${News.newsText}</p>
                    <button type="button" name="button"><a href="comments.html">Коментарі</a></button>
                </div>
            </div>
        </c:forEach>
    </div>
    </div>
</section>
