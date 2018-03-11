<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
    table {
        border: 1px #2d2d2d solid;
    }
    td {
        width: 500px;
        border: 1px #2d2d2d solid;
    }
    .BL {
        width: 300px;
        height: 3px;
        background: black;
    }
</style>

<table>
    <tr>
        <td colspan="2">
            <h1>Статуси</h1>
            <c:forEach items="${statusShowAll}" var="Status">
                <form action="/statusUpdate" method="post">
                    <p>Квартира - ${Status.statusAuthor} </p>
                    <input type="hidden" name="id" value="${Status.id}">
                    <p>Опис -
                        <input type="text" name="statusName" value="${Status.statusName}">
                    </p>
                    <p>Повідомлення -
                        <input type="text" name="statusText" value="${Status.statusText}">
                    </p>
                    <input type="submit" value="Редагувати"> </p>
                </form>
                <form action="/deleteStatus" method="post">
                    <input type="hidden" name="id" value="${Status.id}">
                    <input type="submit" value="Delete">
                </form>

                <div class="BL"></div>
            </c:forEach>
        </td>
    </tr>

    <tr>
        <td>
            <h1>Новини</h1>
            <c:forEach items="${newsShowAll}" var="News">
                <form action="/newsUpdate" method="post">
                    <p>Id - ${News.id}</p>
                    <input type="hidden" name="id" value="${News.id}">
                    <p>Name - <input type="text" name="newsName" value="${News.newsName}"></p>
                    <p>Time - ${News.newsTime}</p>
                    <p>Author - ${News.newsAuthor}</p>
                    <p>Short -<input type="text" name="newsShort" value="${News.newsShort}"></p>
                    <p>Text - <input type="text" name="newsText" value="${News.newsText}"></p>
                        ${News.backscreen}
                    <input type="submit" value="Редагувати">
                </form>
                <form action="/deleteNews" method="post">
                    <input type="hidden" name="id" value="${News.id}">
                    <input type="submit" value="Delete">
                </form>
                <div class="BL"></div>
            </c:forEach>
        </td>

        <td>
            <h1>Голосування</h1>
            <c:forEach items="${dtoVoting.votingListDtoVoting}" var="Voting">
                <form action="/votingUpdate" method="post">
                    <p>Id - ${Voting.votingId}</p>
                    <input type="hidden" name="id" value="${Voting.votingId}">
                    <p>Name - <input type="text" name="votingName" value="${Voting.votingName}"></p>
                    <p>Short -<input type="text" name="votingShort" value="${Voting.votingShort}"></p>
                    <p>Text - <input type="text" name="votingText" value="${Voting.votingText}"></p>
                    <p>True - ${Voting.votingTrue}</p>
                    <p>False - ${Voting.votingFalse}</p>
                    <input type="submit" value="Редагувати">
                </form>
                <form action="/deleteVoting" method="post">
                    <input type="hidden" name="id" value="${Voting.votingId}">
                    <p><input type="submit" value="Delete">Видалити можна лише ті голосування
                        де немає голосів</p>

                </form>
                <div class="BL"></div>
            </c:forEach>
        </td>
    </tr>
</table>