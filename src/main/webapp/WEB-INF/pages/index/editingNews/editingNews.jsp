<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<form action="/newsUpdate" method="post">
    <input type="hidden" name="id" value="${News.id}">
    <p>Ім'я новини</p>
    <input type="text" name="newsName" value="${News.newsName}">
    <p>Текст новини</p>
    <input type="text" name="newsText" value="${News.newsText}">
    <input type="submit" value="Редагувати">
</form>