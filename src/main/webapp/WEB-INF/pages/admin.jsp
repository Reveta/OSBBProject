<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<%--<%@include file="tmp/head.jsp" %>--%>
<%--<%@include file="tmp/navbar.jsp" %>--%>
<%--<%@include file="admin/admin-inputNewsAndVoting-Admin.jsp" %>--%>
<%--<%@include file="admin/admin-outputAll-ADMIN.jsp" %>--%>
<%--<%@include file="tmp/footer.jsp" %>--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>

    <link href="/style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Normalize.css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Custom Styles -->
    <link rel="stylesheet" href="/style/css/admin.css">
</head>
<body>
<div class="admin-panel-container">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <%--<li role="presentation" class="active"><a href="#main" aria-controls="main" role="tab"--%>
                                                  <%--data-toggle="tab">Головна</a></li>--%>
        <li role="presentation"><a href="#voting" aria-controls="voting" role="tab" data-toggle="tab">Голосування</a>
        </li>
        <li role="presentation"><a href="#news" aria-controls="news" role="tab" data-toggle="tab">Новини</a></li>
        <li role="presentation"><a href="#statuses" aria-controls="statuses" role="tab" data-toggle="tab">Статуси</a>
        </li>
        <%--<li role="presentation"><a href="#documents" aria-controls="documents" role="tab"--%>
                                   <%--data-toggle="tab">Документи</a></li>--%>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <%--<div role="tabpanel" class="tab-pane active" id="main">Головна</div>--%>
        <div role="tabpanel" class="tab-pane" id="voting">
            <div class="add-new-voiting-container">
                <h3>Add new voiting</h3>
                <form class="form-horizontal" action="/addVoting" method="post">
                    <div class="form-group">
                        <label for="inputVoitingName">Назва голосування</label>
                        <input type="text" class="form-control" id="inputVoitingName" name="votingName"
                               placeholder="Назва голосування">
                    </div>
                    <div class="form-group">
                        <label for="inputVoitingShortText">Короткий опис голосування</label>
                        <input type="text" class="form-control" id="inputVoitingShortText" name="votingShort"
                               placeholder="Короткий опис новини">
                    </div>
                    <div class="form-group">
                        <label for="inputVoitingFullText">Повний опис голосування</label>
                        <input type="text" class="form-control" id="inputVoitingFullText" name="votingText"
                               placeholder="Текст голосування">
                    </div>
                    <input type="submit" id="addNewVoiting" class="btn btn-default btn-admin" value="Додати">
                    <input type="reset" class="btn btn-default btn-admin">
                </form>

            </div>
            <div class="all-voiting">
                <h3>All voiting</h3>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr class="dark">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Short Text</th>
                        <th>Full Text</th>
                        <th>True</th>
                        <th>False</th>
                        <th>Edit</th>
                        <th>Active</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dtoVoting.votingListDtoVoting}" var="Voting">
                        <tr>
                            <form action="/votingUpdate" method="post">
                                <input type="hidden" name="id" value="${Voting.votingId}">

                                <td>${Voting.votingId}</td>
                                <td><input type="text" name="votingName" value="${Voting.votingName}"></td>
                                <td><input type="text" name="votingShort" value="${Voting.votingShort}"></td>
                                <td><input type="text" name="votingText" value="${Voting.votingText}"></td>
                                <td>${Voting.votingTrue}</td>
                                <td>${Voting.votingFalse}</td>
                                <td>
                                    <input type="submit" id="editVoiting" class="btn btn-default" value="Edit">
                                </td>
                            </form>
                            <td>
                                <form action="/disableVoting" method="get">
                                    <input type="submit" id="deactivateVoiting" class="btn btn-default"
                                           value="Deactivate">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div role="tabpanel" class="tab-pane" id="news">
            <div class="add-new-news-container">
                <h3>Add new news</h3>
                <form class="form-horizontal" action="/addNews" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="newsAuthor" value="${user.username}">

                    <div class="form-group">
                        <label for="inputNewsName">Заголовок новини</label>
                        <input type="text" class="form-control" id="inputNewsName" name="newsName"
                               placeholder="Заголовок новини">
                    </div>
                    <div class="form-group">
                        <label for="inputNewsShortText">Коротко про новину</label>
                        <input type="text" class="form-control" id="inputNewsShortText" name="newsShort"
                               placeholder="Коротко про новину">
                    </div>
                    <div class="form-group">
                        <label for="inputNewsFullText">Текст новини</label>
                        <input class="form-control" id="inputNewsFullText" name="newsText"
                               placeholder="Текст новини">
                    </div>
                    <div class="form-group">
                        <label for="inputNewsImg">Фонова картинка</label>
                        <input type="file" id="inputNewsImg" name="newsBackscreen">
                    </div>
                    <input type="submit" id="addNewNews" class="btn btn-default btn-admin" value="Додати новину">
                    <input type="reset" class="btn btn-default btn-admin">
                </form>

            </div>
            <div class="all-news">
                <h3>All news</h3>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr class="dark">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Date and Time</th>
                        <th>Author</th>
                        <th>Short Text</th>
                        <th>Full Text</th>
                        <th>Image</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${newsShowAll}" var="News">
                        <tr>
                            <form action="/newsUpdate" method="post">
                                <input type="hidden" name="id" value="${News.id}">

                                <td>${News.id}</td>
                                <td><input type="text" name="newsName" value="${News.newsName}"></td>
                                <td>${News.newsTime}</td>
                                <td>${News.newsAuthor}</td>
                                <td><input type="text" name="newsShort" value="${News.newsShort}"></td>
                                <td><input type="text" name="newsText" value="${News.newsText}"></td>
                                <td>${News.backscreen}</td>
                                <td>
                                    <input type="submit" id="editNews" class="btn btn-default" value="Редагувати">
                            </form>
                            <form action="/deleteNews" method="post">
                                <input type="hidden" name="id" value="${News.id}">
                                <input type="submit" value="Видалити" class="btn btn-default">
                            </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <div role="tabpanel" class="tab-pane" id="statuses">
            <div class="add-new-status-container">
                <h3>Add new status</h3>
                <form class="form-horizontal" action="/addStatus" method="post">
                    <input type="hidden" name="statusAuthor" value="Admin">

                    <div class="form-group">
                        <label for="inputStatusDescription">Description</label>
                        <input type="text" class="form-control" id="inputStatusDescription"
                               name="statusName" placeholder="Опис">
                    </div>
                    <div class="form-group">
                        <label for="inputStatusMessage">Message</label>
                        <input class="form-control" id="inputStatusMessage"
                               name="statusText" placeholder="Текст">
                    </div>
                    <input type="submit" id="addNewStatus" class="btn btn-default btn-admin" value="Добавити">
                </form>


            </div>
            <div class="all-status">
                <h3>All voiting</h3>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr class="dark">
                        <th>Id</th>
                        <th>Apartments</th>
                        <th>Description</th>
                        <th>Message</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach items="${statusShowAll}" var="Status">
                        <tr>
                            <form action="/statusUpdate" method="post">
                                <input type="hidden" name="id" value="${Status.id}">


                                <td>${Status.id}</td>
                                <td>${Status.statusAuthor}</td>
                                <td><input type="text" name="statusName" value="${Status.statusName}"></td>
                                <td><input type="text" name="statusText" value="${Status.statusText}"></td>
                                <td class="action">
                                    <input type="submit" id="editStatus" class="btn btn-default"
                                           value="Редагувати">
                            </form>
                            <form action="/deleteStatus" method="post">
                                <input type="hidden" name="id" value="${Status.id}">
                                <input type="submit" value="Delete" class="btn btn-default"
                                       id="deleteStatus">
                            </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%--<div role="tabpanel" class="tab-pane" id="documents">--%>
            <%--Документи--%>
        <%--</div>--%>
    </div>
</div>

<!-- jQuery v.3 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<!-- Custom Scripts -->
<script defer src="/style/js/script.js"></script>
</body>
</html>