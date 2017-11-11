<style>
    <%@include file='/WEB-INF/style/index/input-Admin.css' %>
</style>
<div class="container-fluid">
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
</div>