<%--Це треба написати у кожному модулі, щоб українську мову виводити--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<%--Це доступно тільки юзеру--%>
<sec:authorize access="hasAnyRole('USER')">
    <%--Модуль виводу статуса--%>
    <div class="Status col-lg-11 col-lg-offset-1">
    <p>Status is here</p>

    <%--Форма куди вводити(створити) новий статус--%>
    <form action="/addStatus" method="post">
        <input type="text" name="statusName" placeholder="Опис">
        <input type="text" name="statusText" placeholder="Текст">
        <input type="hidden" name="statusAuthor" value="${user.username}">
        <input type="submit">
    </form>

    <%--Цикл який виводить статуси--%>
    <c:forEach items="${statusShowAll}" var="Status">
        <%--Шаблон нового статуса, те як виводити кожен статус--%>

        Квартира - ${Status.statusAuthor}
        <%--вивести ім'я статуса--%>
        Опис - ${Status.statusName}
        <%--вивести текст статуса--%>
        Повідомлення - ${Status.statusText}
        <form action="/deleteStatus">
            <input type="hidden" name="id" value="${Status.id}">
            <input type="submit" value="X">
        </form>

    </c:forEach>
</div>
</sec:authorize>
