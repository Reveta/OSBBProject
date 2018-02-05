<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="commentBlock">
    <c:forEach items="${News.newsComment}" var="Comment">

        <div class="col-lg-12 col-md-12 col-sm-12">
            <form action="/deleteComment">
                <input type="hidden" name="newsId" value="${News.id}">
                <input type="hidden" name="commentId" value="${Comment.id}">
                <input type="submit" value="X">

            <p1>${Comment.userName} ${Comment.time}</p1>
            </form>
        </div>
        <br>
        ${Comment.commentValue}
        <br>
    </c:forEach>

    <sec:authorize access="hasAnyRole('USER','ADMIN')">
        <form action="/addComment" method="post">
            <input type="hidden" name="id" value="${News.id}">
                <%--очікуємо на Principal--%>
                <%--<<input type="hidden" name="userName" value="${"Житель: " + User.name + " " + User.prename}">>--%>
            <input type="text" name="commentValue">
            <input type="submit" value="addComment">
        </form>
    </sec:authorize>
</div>