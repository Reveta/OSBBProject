<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<section id="inform-apartment">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <%--<c:forEach items="${showUserInfo}" var="User">--%>
                    <form action="/updatePersonalInfo" method="post">
                            <%--<h1><span class="bold" title="Код квартири в базі ОСББ"><i class="fa fa-home" aria-hidden="true"> 325</i></span></h1>--%>
                        <h2> Вул. Шевченка 42, кв. 25</h2>
                            <%--<br>--%>
                        <h2>Мешканці квартири :</h2>

                                <p>${currentUser}</p>

                        <input type="hidden" name="id" value="${User.id}">
                        <input type="text" name="name" value="${User.name}">
                        <input type="tel" name="prename" value="${User.prename}">
                        <input type="number" name="phone" value="${User.phoneNumber}">
                        <input type="email" name="email" value="${User.email}">
                        <input type="text" name="text" value="${User.someInfo}">
                        <input type="submit" value="GO">

                        <br>
                        <h3><a href="#">додати мешканця</a></h3>
                        <br>
                    </form>
                <%--</c:forEach>--%>
            </div>
        </div>
    </div>
</section>