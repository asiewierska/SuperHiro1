<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Profile - informacje</title>
</head>
<body>
<div>
    Strona home
</div>
    <br>
    <br>

    <a href="<c:url value="all" />"<button type="button" class="btn btn-default"/>Wszystkie profile posortowane</a>
    <br>
    <br>
    <a href="<c:url value="find" />"<button type="button" class="btn btn-default"/>Strona wyszukiwania</a>

</body>
</html>
