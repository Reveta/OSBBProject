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
                    <sec:authorize access="isAnonymous()">
                        <li id="log-in">
                            <a href="/login">Вхід
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            </a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('USER','ADMIN')">
                        <li id="log-out">
                            <a href="/logout">Вихід
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                            </a>
                        </li>
                    </sec:authorize>
                    <li class="nav-date" id="nav-date"></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section id="main-page" class="main-page">
    <div id="news" class="news">
        <div class="container container-news">
            <div class="news-status-container">
                <div id="status" class="nav-status">
                    <ul class="nav navbar-nav navbar-left navbar-status">
                        <c:forEach items="${statusShowAll}" var="Status">
                            <li class="active">
                                <a href="#status">${Status.statusName}; ${Status.statusText}
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

            <!-- News Slider -->
            <div id="news-slider" class="news-slider">
                <div class="news-slider-list">
                    <div class="news-slider-item " id="news-slider-item-1">
                        <div class="news-slider-container">
                            <div class="news-slider-content">
                                <div class="news-slider-header">
                                    <h3><a href="#news-date" class="gold">${newsLast.newsTime}</a></h3>
                                    <h1>${newsLast.newsName}</h1>
                                </div>
                                <div class="news-slider-section">
                                    <p> ${newsLast.newsText} </p>
                                </div>
                                <div class="news-slider-footer">
                                    <div class="news-meta">
                                        <div class="news-meta-content">
                                            <span class="news-author-date">
                                                <a href="https://vk.com/reveta_ua">
                                                    <img src="sourses/img/pankiv.jpg" alt="Pankiv">
                                                </a>
                                                <span>
                                                    <a href="#news-author" class="news-author">Pankiv,</a>
                                                </span>
                                                <a href="#news-date" class="news-date">${newsLast.newsTime} </a>
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
                </div>

                <div class="news-slider-mini-list">
                    <c:forEach items="${newsListTree}" var="News">
                        <div class="news-mini-item">
                            <div class="news-mini-img" id="news-mini-img-1">
                                <img src="sourses/img/news1.jpg" alt="news">
                            </div>
                            <div class="news-mini-content">
                                <div class="news-mini-date-container">
                                    <div class="news-mini-dates">
                                        <a href="#date" class="news-mini-date gold"> ${News.newsTime}; </a>
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
        <div class="carousel">
            <div class="carousel-button carousel-button-prev" id="carousel-button-prev">
                <a href="#prev" class="gold">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                </a>
            </div>
            <div class="carousel-button carousel-button-next" id="carousel-button-next">
                <a href="#next" class="gold">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                </a>
            </div>

            //Карусель працює не правильно, воно кожного разу підтягує інфу з бази

            <div class="container">
                <div class="carousel-wrapper">
                    <div class="carousel-items">
                        <c:forEach items="${newsShowAll}" var="News">
                            <div class="carousel-item">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date"> ${News.newsTime};</a></p>
                                    <p class="archive-news-title"><a href="#news">${News.newsName}</a></p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>

    </div>
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