<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="col-lg-12 col-md-12 col-sm-12">
<p>Активне голосування</p>

    <div class="col-lg-8 col-md-6 col-sm-6">
        <form action="/deleteVoting">
            <input type="hidden" name="id" value="${votingActive.id}">
            <input type="submit" value="X">
        </form>
        <h1>
            <a href="/newsPage">Ім'я голосування:${votingActive.votingName}</a>
        </h1>
        <%--<p>${News.newsTime}</p> // має бути voting--%>
        <p>Короткий опис голосування: ${votingActive.votingShort}</p>
        <p>Текст голосування: ${votingActive.votingText}</p>
        <p>qweqrqdafsdqw</p>
        <%--<div>--%>
        <%--<p>За: ${Voting.votingTrue}</p>--%>
        <%--<p>Проти: ${Voting.votingFalse}</p>--%>
        <%--</div>--%>
        <c:forEach items="${votingActive.voteList}" var="Vote">
            <br>
            <%--${Vote.voteList_id}--%>
            <%--${Vote.user_id}--%>
            ${Vote.vote}
        </c:forEach>
        <%--<%@include file="index-userVoit-User.jsp" %>--%>
        <p>qweqrqdafsdqw</p>
    </div class="col-lg-8 col-md-6 col-sm-6">


</div>

<p>Голосування</p>

<c:forEach items="${votingShowAll}" var="Voting">


    <div class="col-lg-8 col-md-6 col-sm-6">
        <form action="/deleteVoting">
            <input type="hidden" name="id" value="${Voting.id}">
            <input type="submit" value="X">
        </form>
        <h1>
            <a href="/newsPage">Ім'я голосування:${Voting.votingName}</a>
        </h1>
        <%--<p>${News.newsTime}</p> // має бути voting--%>
        <p>Короткий опис голосування: ${Voting.votingShort}</p>
        <p>Текст голосування: ${Voting.votingText}</p>
<p>qweqrqdafsdqw</p>
        <%--<div>--%>
        <%--<p>За: ${Voting.votingTrue}</p>--%>
        <%--<p>Проти: ${Voting.votingFalse}</p>--%>
        <%--</div>--%>
        <c:forEach items="${Voting.voteList}" var="Vote">
            <br>
            <%--${Vote.voteList_id}--%>
            <%--${Vote.user_id}--%>
            ${Vote.vote}
        </c:forEach>
        <%--<%@include file="index-userVoit-User.jsp" %>--%>
        <p>qweqrqdafsdqw</p>
    </div class="col-lg-8 col-md-6 col-sm-6">


    </div>
</c:forEach>