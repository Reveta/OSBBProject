<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="tmp/header.jsp" %>

Login page
<br>

<c:url var="xxx" value="/admin"/>
<form action="${xxx}" method="post">

    <%--<c:if test="${param.error = !null}">--%>
    <%--<p>ERROR MAZAFAKA</p>--%>
    <%--</c:if>--%>
    <%--<c:if test="${param.logout != null}">--%>
    <%--<p>SYPER</p>--%>
    <%--</c:if>--%>

    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login"/>


    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<%@include file="tmp/footer.jsp" %>