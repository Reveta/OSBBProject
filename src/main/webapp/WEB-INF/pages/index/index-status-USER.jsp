<%--Це треба написати у кожному модулі, щоб українську мову виводити--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--Модуль виводу статуса--%>
<%--Це доступно тільки юзеру--%>
<div class="Status">
    <p>Status is here</p>

<%--Форма куди вводити(створити) новий статус--%>
    <form action="/addStatus" method="post">
        <input type="text" name="statusName">
        <input type="text" name="statusText">
        <input type="submit">
    </form>

<%--Цикл який виводить статуси--%>
    <c:forEach items="${statusShowAll}" var="Status">
<%--Шаблон нового статуса, те як виводити кожен статус--%>

        <%--вивести ім'я статуса--%>
        ${Status.statusName};
        <%--вивести текст статуса--%>
        ${Status.statusText};

    </c:forEach>
</div>