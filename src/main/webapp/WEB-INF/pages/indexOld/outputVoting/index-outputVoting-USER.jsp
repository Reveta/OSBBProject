<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="col-lg-12 col-md-12 col-sm-12">
    <p>Активне голосування</p>

    <div class="col-lg-8 col-md-6 col-sm-6">
        <div>Початок голосування</div>
        <form action="/deleteVoting">
            <input type="hidden" name="id" value="${dtoVoting.votingId}">
            <input type="submit" value="X">
        </form>
        <h1>
            <a href="/newsPage">Ім'я голосування:${dtoVoting.votingName}</a>
        </h1>voting
        <p>Короткий опис голосування: ${dtoVoting.votingShort}</p>
        <p>Текст голосування: ${dtoVoting.votingText}</p>
        <div>Місце для голосувань</div>
        <div>
            <p>За проголосувало ${dtoVoting.votingTrue}</p>
            <p>Проти проголосувало ${dtoVoting.votingFalse}</p>
        </div>
        <div>Кінець голосування</div>
    </div>


</div>

<p>Голосування</p>

<c:forEach items="${dtoVoting.votingListDtoVoting}" var="Voting">


    <div class="col-lg-8 col-md-6 col-sm-6">
        <div>Початок голосування</div>
        <form action="/deleteVoting">
            <input type="hidden" name="id" value="${Voting.votingId}">
            <input type="submit" value="X">
        </form>
        <h1>
            <a href="/newsPage">Ім'я голосування:${Voting.votingName}</a>
        </h1>
        <p>Короткий опис голосування: ${Voting.votingShort}</p>
        <p>Текст голосування: ${Voting.votingText}</p>
        <div>Місце для голосувань</div>
        <div>
            <p>За проголосувало ${Voting.votingTrue}</p>
            <p>Проти проголосувало ${Voting.votingFalse}</p>
        </div>
        <div>Кінець голосування</div>
    </div>


    </div>
</c:forEach>