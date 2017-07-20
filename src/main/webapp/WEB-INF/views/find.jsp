<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Profile - szukaj po id</title>
</head>
<body>

    <form:form method="post" modelAttribute="profile">
        <div class="row">
            <div class="form-group">
                <label for="id">Wpisz id</label>
                <form:input path="id" class="form-control" required="required"/>
            </div>
        </div>

        <input type="submit" class="btn btn-primary" role="button" value="Szukaj"/>
    </form:form>

</body>
</html>
