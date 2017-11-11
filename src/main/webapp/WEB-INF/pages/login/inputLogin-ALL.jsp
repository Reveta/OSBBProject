


<c:url var="xxx" value="/admin"/>
<form action="${xxx}" method="post">

    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login"/>


    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>