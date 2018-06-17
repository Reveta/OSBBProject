<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--Ось це треба писати на кожній сторінці та підсторінці, щоб виводити українську.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<%--Статус голосування - ${status}--%>

<%--<sec:authorize access="hasAnyRole('ADMIN','USER')">--%>
<%--<%@include file="admin/admin-inputNewsAndVoting-Admin.jsp" %>--%>
<%--</sec:authorize>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Ваше ОСББ </title>

    <!-- Normalize.css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Custom Styles -->
    <link rel="stylesheet" href="style/css/style.css">
</head>
<body>
<!-- ===== Header ===== -->
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
                <a class="navbar-brand" href="/index"> Ваше ОСББ </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="isAnonymous()">
                        <li id="log-in">
                            <a href="/login">Вхід
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            </a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('USER')">
                        <li class="active"><a href="/cabinet">Кабінет</a></li>
                        <%--<li><a href="#" id="Voting">Голосування</a></li>--%>
                        <%--<li><a href="#">Документи</a></li>--%>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('USER','ADMIN')">
                        <li id="log-in">
                            <a href="/logout">Вихід
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            </a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <li id="log-in">
                            <a href="/admin">Адмін-панель
                                <span class="glyphicon glyphicon-ice-lolly-tasted" aria-hidden="true"></span>
                            </a>
                        </li>
                    </sec:authorize>


                    <li class="nav-date" id="nav-date"></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<%--<p style="color: black">status - ${status}</p>--%>
<%--<p style="color: black">checkUser - ${checkUser}</p>--%>
<%--<p style="color: black">newsId - ${newsId}</p>--%>
<!-- ===== Main Page ===== -->
<section id="main-page" class="main-page">

    <br>
    <br>
    <br>

    <!-- ===== Statuses ===== -->
    <%--<div id="status-container" class="status-container">--%>
        <%--<div class="container">--%>
            <%--<div id="status" class="nav-status">--%>
                <%--<ul class="nav navbar-nav navbar-left navbar-status">--%>
                    <%--<li id="status-1">--%>
                       <%--<span class="status">--%>
                            <%--<button class="get-more-info-about-status"><span--%>
                                    <%--class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></button>--%>
                            <%--<button class="delete-status"><span class="glyphicon glyphicon-remove"--%>
                                                                <%--aria-hidden="true"></span></button>--%>
                        <%--</span>--%>
                        <%--<!-- ===== More Info About Status ===== -->--%>
                    <%--</li>--%>
                    <%--<li id="status-2">--%>
                       <%--<span class="status">--%>
                            <%--<button class="get-more-info-about-status"><span--%>
                                    <%--class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></button>--%>
                            <%--<button class="delete-status"><span class="glyphicon glyphicon-remove"--%>
                                                                <%--aria-hidden="true"></span></button>--%>
                        <%--</span>--%>
                        <%--<!-- ===== More Info About Status ===== -->--%>
                    <%--</li>--%>
                    <%--<li id="status-3">--%>
                       <%--<span class="status">--%>
                            <%--<button class="get-more-info-about-status"><span--%>
                                    <%--class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></button>--%>
                            <%--<button class="delete-status"><span class="glyphicon glyphicon-remove"--%>
                                                                <%--aria-hidden="true"></span></button>--%>
                        <%--</span>--%>
                        <%--<!-- ===== More Info About Status ===== -->--%>
                    <%--</li>--%>
                <%--</ul>--%>


                <%--<!-- ===== Delete Status Verefication ===== -->--%>
                <%--<div class="delete-status-verification">--%>
                    <%--<h5>Ви дійсно хочете видалити статус?</h5>--%>
                    <%--<input type="submit" id="delete" class="btn btn-delete" value="Так">--%>
                    <%--<input type="submit" id="cancel" class="btn btn-cancel" value="Ні">--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!-- ===== News ===== -->

    <div id="news" class="news">
        <div class="container container-news">
            <!-- News Slider -->

            <div id="news-slider" class="news-slider">
                <!--Div that will hold the pie chart-->

                <div class="bg-grey">
                    <div id="chart_div" class="chart_div"></div>
                </div>

                <div class="news-slider-list">
                    <div class="news-slider-item " id="news-slider-item-1">

                        <div class="news-slider-container">
                            <div class="news-slider-content">
                                <!-- Slider News Title -->
                                <div class="news-slider-header">

                                    <h3><a href="#news-date" class="gold">${newsLast.newsTime}</a></h3>
                                    <h1>${newsLast.newsName}</h1>
                                </div>
                                <!-- Slider News text -->
                                <div class="news-slider-section">
                                    <h2 class="news-short-info">${newsLast.newsShort}</h2>
                                    <hr>
                                    <p class="news-text">${newsLast.newsText}</p>
                                </div>

                                <!-- Slider News Reviews -->
                                <div class="news-slider-reviews">
                                    <div id="review-1" class="review">
                                        <div class="review-photo">
                                            <img src="style/images/punkiv.jpg" alt="review-img">
                                        </div>
                                        <div class="review-name-date">
                                            <span class="review-name"><a href="#user">Romasia Punkiv</a></span>,
                                            <span class="review-date gold">${News.newsTime}</span>
                                        </div>
                                        <div class="review-text">
                                            <c:forEach items="${lastComments}" var="Comment">
                                                <hr>
                                                ${Comment.time}
                                                <br>
                                                ${Comment.userName} -> ${Comment.commentValue}
                                                <%--${newsLast.newsComment} 1111111111--%>
                                            </c:forEach>
                                        </div>

                                    </div>

                                    <!-- Form for send review -->
                                    <sec:authorize access="hasAnyRole('USER', 'ADMIN')">
                                        <div class="review-form">
                                            <form action="/addComment" method="post">
                                                <label for="textarea">Write comment:</label>
                                                <input type="hidden" name="id" value="${newsLast.id}">
                                                <textarea class="form-control" rows="3" id="textarea"
                                                          name="commentValue"></textarea>
                                                <input class="btn btn-send" type="submit" value="Відправити">
                                            </form>
                                        </div>
                                    </sec:authorize>
                                </div>
                                <!-- Slidet News Footer -->
                                <div class="news-slider-footer">
                                    <div class="news-meta">
                                        <div class="news-meta-content">
                                            <span class="news-author-date">
                                                <a href="https://vk.com/reveta_ua">
                                                    <img src="style/images/punkiv.jpg" alt="Punkiv">
                                                </a>
                                                <span>
                                                    <a href="#news-author"
                                                       class="news-author">${newsLast.newsAuthor},</a>
                                                </span>
                                                <%--<a href="#news-date" class="news-date">11 minute ago</a>--%>
                                            </span>
                                            <a href="#news-coments" class="news-coments" id="openReviews">
                                                <span class="glyphicon glyphicon-comment"></span>
                                                ${countOfComments}
                                            </a>
                                            <a href="#news-coments" class="news-coments close-reviews"
                                               id="closeReviews">
                                                <span class="glyphicon glyphicon-bell"></span> Back to news
                                            </a>

                                            <span></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="news-slider-mini-list">
                    <c:forEach items="${threeLastNews}" var="threeNews">
                        <div class="news-mini-item">
                            <div class="news-mini-img" id="news-mini-img-1">
                                <img src="style/images/news1.jpg" alt="news">
                            </div>

                            <div class="news-mini-content">
                                <div class="news-mini-date-container">
                                    <div class="news-mini-dates">
                                        <a href="#date" class="news-mini-date gold"> ${threeNews.newsTime} </a>
                                    </div>
                                </div>
                                <h4 class="news-mini-title">
                                    <a href="/newsPage-${threeNews.id}">${threeNews.newsShort}</a>
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
            <div class="container">
                <div class="carousel-wrapper">
                    <div class="carousel-items">
                        <c:forEach items="${karuselNews}" var="karuselNews">
                            <div class="carousel-item">
                                <div class="archive-news-item">
                                    <p class="archive-news-date"><a href="#date">${karuselNews.newsTime}</a></p>
                                    <p class="archive-news-title"><a
                                            href="/newsPage-${karuselNews.id}">${karuselNews.newsName}</a></p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!— Google Chart —>
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>

<!— jQuery v.3 —>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!— Latest compiled and minified JavaScript —>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<!— Custom Scripts —>

<%--<sec:authorize access="hasAnyRole('USER')">--%>
    <script type="text/javascript" defer src="/style/js/script.js"></script>
<%--</sec:authorize>--%>

<script type="text/javascript" defer>

    <%--var newsId = ${newsId};--%>
    var votingId = ${activeVotingId};
    var status = ${status};
    var votingText = '${dtoVoting.votingText}';
    var tr = ${dtoVoting.votingTrue};
    var fal = ${dtoVoting.votingFalse};
    var checkUser = ${checkUser};

    $('#Voting').on('click', function () {
        $(".bg-grey").css({"display": "none"});
    });
</script>

<%--<sec:authorize access="hasAnyRole('USER')">--%>
    <script type="text/javascript" defer src="/style/js/chart.js"></script>
<%--</sec:authorize>--%>
</body>
</html>