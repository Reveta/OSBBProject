<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="tmp/header.jsp" %>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%--<%@include file="index/inputNewsandVoting-Admin.jsp" %>--%>
<%--//Було б добре, якби це можна було виводити тільки для адміна--%>

<sec:authorize access="hasAnyRole('ADMIN')">
    <%@include file="index/inputNewsandVoting-Admin.jsp" %>
</sec:authorize>

<%@include file="index/outputNewsandVoting-ALL.jsp" %>


<%@include file="tmp/footer.jsp" %>