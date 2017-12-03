<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<section id="inform-apartment">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form action="/updatePersonalInfo" method="post">

                    <h2> Вул. Шевченка 42, кв. 25</h2>
                    <h2>Мешканці квартири :</h2>

                    <input type="hidden" name="id" value="${User.id}">
                    <input type="text" name="name" value="${User.name}">
                    <input type="text" name="prename" value="${User.prename}">
                    <input type="tel" name="phoneNumber" value="${User.phoneNumber}">
                    <input type="email" name="email" value="${User.email}">
                    <input type="text" name="someInfo" value="${User.someInfo}">
                    <input type="submit" value="GO">

                    <h3><a href="#">додати мешканця</a></h3>

                </form>
            </div>
        </div>
    </div>
</section>