<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<!-- Велика картинка з написом -->
<div class="img_elastic" id="headerwrap">
    <h1 class="margin-top-70">Твори своє майбунє разом з ОСББ "Струмочок"</h1>
</div>

<section id="news">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 margin-bottom-70">
                <h2 class="section-title">Актуальні новини та оголошення</h2>
            </div>
        </div>

        <%--<c:forEach items="${newsShowAll}" var="News">--%>
        <%--<h1>${News.newsName}</h1>--%>
        <%--</c:forEach>--%>


        <c:forEach items="${newsShowAll}" var="News">
            <div class="row one-news">
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <img class="img_elastic" src="images/darth_vader 1.png" alt="">
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

<section id="google-map">
    <iframe class="zbilshutu"
            src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d14982.572422669027!2d24.03547285225868!3d49.839262794214314!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1suk!2sua!4v1510237958257"
            width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
</section>