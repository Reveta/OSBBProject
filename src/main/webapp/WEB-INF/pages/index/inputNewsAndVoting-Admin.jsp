<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<style>
    <%@include file='/style/index/inputNewsAndVoting-Admin.css' %>
</style>


<div class="container-fluid">
    <div class="votingInput col-xs-6">
        <form action="/addVoting" method="post">
            <input type="text" name="votingName" placeholder="Name of voting">
            <input type="text" name="votingText" placeholder="Text of voting">
            <input type="submit" value="addVoting">
            <input type="reset">
        </form>
    </div>

    <div class="newsInput col-xs-6">
        <form action="/addNews" method="post">
            <input type="text" name="newsName" placeholder="Name of news">
            <input type="text" name="newsText" placeholder="Text of news">
            <input type="submit" value="addNews">
            <input type="reset">
        </form>
    </div>
</div>