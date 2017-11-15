<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<style>
    <%@include file='/style/index/outputNewsAndVoting-ALL.css' %>
</style>

<body>

<p>Test gitHub</p>

<div class="block container-fluid">
    <div class="colLeft col-xs-6">
        <h2>Place for yours news</h2>
        <c:forEach items="${newsShowAll}" var="News">
            <div class="newsBox">
                <div class="newsNameBox">
                    <h1>${News.newsName}</h1>
                </div>
                <hr>
                <div class="newsTextBox">
                    <p>${News.newsText}</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="colRight col-xs-6">
        <h2>Place for yours voting</h2>
        <c:forEach items="${votingShowAll}" var="Voting">
            <div class="newsBox">
                <div class="newsNameBox">
                    <h1>${Voting.votingName}</h1>
                </div>
                <hr>
                <div class="newsTextBox">
                    <p>${Voting.votingText}</p>
                </div>
            </div>
            <br>
        </c:forEach>
    </div>
</div>
</body>