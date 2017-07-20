<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Profile - wyszukane po id</title>
</head>
<body>

    <div style="color:red;">${status}</div>
    <br>
    id : ${profile.id}
    <br>
    birthday : ${profile.birthday}
    <br>
    occupation : ${profile.occupation}
    <br>
    gender : ${profile.gender}
    <br>
    firstName : ${profile.firstName}
    <br>
    lastName : ${profile.lastName}
    <br>
    city : ${profile.city.countryName}, ${profile.city.cityName}, ${profile.city.stateName}, ${profile.city.coords.lon}, ${profile.city.coords.lat}
    <br>
    work : ${profile.work}
    <br>
    friends : ${profile.friends}
    <br>
    school : ${profile.school}
    <br>
    location : ${profile.location}
    <br>
    relationship : ${profile.relationship}
    <br>
    posts : ${profile.posts}
    <br>
    <br>

</body>
</html>
