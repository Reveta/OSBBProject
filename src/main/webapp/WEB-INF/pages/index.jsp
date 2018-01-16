<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--Ось це треба писати на кожній сторінці та підсторінці, щоб виводити українську.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> OSBB </title>

    <!-- Normalize.css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Custom Styles -->
    <link rel="stylesheet" href="/style/index/sourses/css/style.css">
</head>
<body>
<header id="header" class="header">
    <nav class="navbar navbar-dark">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"> OSSB Струмочок </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="hasAnyRole('USER')">
                    <li class="active"><a href="/cabinet">Кабінет</a></li>
                    </sec:authorize>
                    <%--<li><a href="#">Голосування</a></li>--%>
                    <%--<li><a href="#">Документи</a></li>--%>
                    <sec:authorize access="hasAnyRole('USER','ADMIN')">
                    <li>
                        <a href="#" id="vissible-category">Статус
                            <!--<span class="glyphicon glyphicon-menu-down test" aria-hidden="true"></span>-->
                        </a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('USER','ADMIN')">
                    <li>
                        <a href="/logout">Вихід
                            <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                        </a>
                    </li>
                    </sec:authorize>

                    <sec:authorize access="isAnonymous()">
                    <li>
                        <a href="/login">Увійти
                            <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                        </a>
                    </li>
                    </sec:authorize>

                    <li class="nav-date" id="nav-date"></li>
                </ul>
            </div>
        </div>
    </nav>


    <div id="categories" class="nav-categories">
        <div class="container">
            <ul class="nav navbar-nav navbar-right navbar-categories">
                <c:forEach items="${statusShowAll}" var="Status">
                <li>
                    <a href="#category">${Status.statusName}; ${Status.statusText};
                        <span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
                    </a>
                    <form action="/deleteStatus">
                        <input type="hidden" name="id" value="${Status.id}">
                        <input type="submit" value="X">
                    </form>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</header>

<section id="main-page" class="main-page">
    <div id="news" class="news">
        <div class="container container-news">
            <div id="news-slider" class="news-slider">
                <div class="news-slider-list">
                    <div class="news-slider-item " id="news-slider-item-1">
                        <div class="news-slider-container">
                            <div class="news-slider-content">
                                <h3><a href="#news-date" class="gold">${newsLast.newsTime}</a></h3>
                                <h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h1>
                                <p>${newsLast.newsText}</p>
                                <div class="news-meta">
                                    <div class="news-meta-content">
                                        <span class="news-author-date">
                                            <a href="https://vk.com/reveta_ua">
                                                <img src="sourses/img/punkiv.jpg" alt="Punkiv">
                                            </a>
                                            <span>
                                                <a href="#news-author" class="news-author">Pankiv,</a>
                                            </span>
                                            <a href="#news-date" class="news-date">11 minute ago</a>
                                        </span>
                                        <a href="#news-coments" class="news-coments">
                                            <span class="glyphicon glyphicon-comment"></span> 1
                                        </a>
                                        <span class="news-readtime">
                                            <span class="glyphicon glyphicon-time"></span>1 min<span>read</span>
                                        </span>
                                        <span class="news-views">
                                            <span class="glyphicon glyphicon-eye-open"></span>2395
                                        </span>
                                        <span></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="news-slider-mini-list">
                    <c:forEach items="${newsListTree}" var="News">


                    <div class="news-mini-item">
                        <div class="news-mini-img news-mini-img-1"></div>
                        <div class="news-mini-content">
                            <div class="news-mini-date-container">
                                <div class="news-mini-dates">
                                    <a href="#date" class="news-mini-date"> ${News.newsTime}; ${News.newsName}</a>
                                </div>
                            </div>
                            <h4 class="news-mini-title">
                                <a href="#news">${News.newsShort};</a>
                            </h4>
                        </div>
                    </div>
                    </c:forEach>


                </div>



            </div>
        </div>
    </div>

    <div id="archive-news" class="archive-news">
        <!--        <div class="container">-->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> 15.01.2018 </a></p>
                                    <p class="archive-news-title"><a href="#news">Lorem ipsum dolor sit amet,
                                        consectetur adipisicing elit.</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!--        </div>-->
    </div>
</section>


<!-- jQuery v.3 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<!-- Custom Scripts -->
<script src="/style/index/sourses/js/script.js"></script>
</body>
</html>