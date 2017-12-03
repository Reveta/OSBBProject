<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--Ось це треба писати на кожній сторінці та підсторінці, щоб виводити українську.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@include file="tmp/head.jsp" %>

<%@include file="tmp/navbar.jsp" %>
<sec:authorize access="hasAnyRole('ADMIN')">
    <%@include file="admin/admin-inputNewsAndVoting-Admin.jsp" %>
</sec:authorize>
<%@include file="index/index-bigPicture-ALL.jsp" %>
<%@include file="index/index-outputNews-ALL.jsp" %>
<%@include file="index/index-googleMap-ALL.jsp" %>

<%@include file="tmp/footer.jsp" %>