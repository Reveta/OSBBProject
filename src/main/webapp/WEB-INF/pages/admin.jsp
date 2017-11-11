<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="tmp/header.jsp" %>

<style>
    <%@include file='/WEB-INF/style/index/input-Admin.css' %>
</style>
<div class="container-fluid">
    <h1>Admin store</h1>
    <div class="newsInput col-xs-6">
        <form action="addNews" method="post">
            <input type="text" name="newsName" placeholder="Name of news">
            <input type="text" name="newsText" placeholder="Text of news">
            <%--<input type="text" name="" placeholder="">--%>
            <input type="submit" value="addNews">
        </form>
    </div>

    <div class="votingInput col-xs-6">
        <form action="addVoting" method="post">
            <input type="text" name="votingName" placeholder="Name of voting">
            <input type="text" name="votingText" placeholder="Text of voting">
            <input type="submit" value="addVoting">
        </form>
    </div>

    <a href="/logout">logout</a>
</div>

<%@include file="tmp/footer.jsp" %>