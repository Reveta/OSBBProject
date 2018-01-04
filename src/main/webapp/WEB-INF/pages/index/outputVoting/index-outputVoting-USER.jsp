<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="col-lg-12 col-md-12 col-sm-12">
<p>Голосування</p>

<c:forEach items="${votingShowAll}" var="Voting">


    <div class="col-lg-8 col-md-6 col-sm-6">
        <h1>
            <a href="/newsPage">Ім'я голосування:${Voting.votingName}</a>
        </h1>
        <p>${News.newsTime}</p> // має бути voting
        <p>Короткий опис голосування: ${Voting.votingShort}</p>
        <p>Текст голосування: ${Voting.votingText}</p>

        <%--<div>--%>
        <%--<p>За: ${Voting.votingTrue}</p>--%>
        <%--<p>Проти: ${Voting.votingFalse}</p>--%>
        <%--</div>--%>

        <%@include file="index-userVoit-User.jsp" %>

    </div>


    </div>
</c:forEach>