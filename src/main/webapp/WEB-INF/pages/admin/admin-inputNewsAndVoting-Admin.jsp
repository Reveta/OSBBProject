<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<style>
    <%@include file='/style/index/inputNewsAndVoting-Admin.css' %>
</style>


<div class="container-fluid">
    <div class="votingInput col-xs-6">
        <form action="/addVoting" method="post">
            <input type="text" name="votingName" placeholder="Назва голосування">
            <input type="text" name="votingShort" placeholder="Короткий опис">
            <input type="text" name="votingText" placeholder="Текст голосування">
            <input type="submit" value="addVoting">
            <input type="reset">
        </form>
    </div>

    <div class="newsInput col-xs-6">
        <form action="/addNews" method="post">
            <input type="text" name="newsName" placeholder="Заголовок новини">
            <input type="text" name="newsShort" placeholder="Коротко про новину">
            <input type="text" name="newsText" placeholder="Текст новини">
            <input type="submit" value="addNews">
            <input type="reset">
        </form>
    </div>

</div>