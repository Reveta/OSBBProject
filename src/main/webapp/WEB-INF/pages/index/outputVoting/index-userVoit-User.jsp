<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--<form action="/addUserVote" method="post">--%>
    <%--<input type="hidden" name="id" value="${Voting.id}">--%>

    <%--<input type="radio" name="userVote" value="${Voting.votingTrue}" formaction="/addTrue" formmethod="post"> За: ${Voting.votingTrue}--%>
    <%--<input type="radio" name="userVote" value="votingFalse" formaction="/addFalse" formmethod="post"> Проти: ${Voting.votingFalse}--%>
    <%--<input type="submit" value="Голосувати">--%>
<%--</form>--%>

<form action="/addTrue" method="post">
    <input type="hidden" name="id" value="${Voting.id}">
    За:    ${Voting.votingTrue}
    <button type="submit" name="count" value="${Voting.votingTrue}"><img src="/style/images/like.png" width="50px" height="50px"></button>
</form>
<form action="/addFalse" method="post">
    <input type="hidden" name="id" value="${Voting.id}">
    Проти: ${Voting.votingFalse}
    <button type="submit" name="count" value="${Voting.votingFalse}"><img src="/style/images/dislike.png" width="50px" height="50px"></button>
</form>

<%--<button id="true"><img src="/style/images/like.png" width="40px" height="40px">Za: </button>--%>
<%--<button id="false"><img src="/style/images/like.png" width="40px" height="40px">Protu: ${Voting.votingFalse}</button>--%>

<%--<div class="target"></div>--%>
    <%--<script>--%>
        <%--$("#true").click(() => {--%>

            <%--$('.target').empty();--%>
            <%--$.ajax({--%>
                <%--url: '/addTrue',--%>
                <%--type: 'POST',--%>
                <%--success: function (result) {--%>
                    <%--console.log(result);--%>
                    <%--let value = result;--%>

                    <%--let $p = $("<p/>", {text : value.votingTrue});--%>
                    <%--$(".target").append($p);--%>

                    <%--alert("Ваш голос надіслано");--%>
                <%--},--%>
                <%--error: function () {--%>
                    <%--alert("помилка");--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>

    <%--</script>--%>
