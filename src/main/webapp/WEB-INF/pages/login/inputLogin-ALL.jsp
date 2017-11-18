<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:url var="xxx" value="/admin"/>

<div class="img_elastic" id="headerwrap">
<h1 class="margin-top-70">LOGIN</h1>
<form id="login-form" action="${xxx}" method="post">
    <div class="form-group">
        <input type="text" name="username"
               class="form-control center" id="email" placeholder="Введіть ім'я">
    </div>
    <div class="form-group">
        <input type="password" name="password"
               class="form-control center" id="pwd" placeholder="Введіть пароль">
    </div>
    <input type="submit" class="btn btn-default" value="Submit"/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</div>


<%--<h1 class="margin-top-70">LOGIN</h1>--%>
<%--<form id=login-form >--%>
<%--<div class="form-group">--%>
<%--<!-- <label for="email">Email:</label> -->--%>
<%--<input type="email" class="form-control center" id="email" placeholder="Введіть email">--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<!-- <label for="pwd">Password:</label> -->--%>
<%--<input type="password" class="form-control center" id="pwd" placeholder="Введіть пароль">--%>
<%--</div>--%>
<%--<!-- <div class="checkbox">--%>
<%--<label><input type="checkbox"> Remember me</label>--%>
<%--</div> -->--%>
<%--<button type="submit" class="btn btn-default">Submit</button>--%>
<%--</form>--%>
<%--</div>--%>