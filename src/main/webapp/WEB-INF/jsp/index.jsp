<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>University app</title>
</head>
<body>
<h1><spring:message key="greeting"/></h1>
<form action="/login">
    <input type="submit" value="<spring:message key="label.login"/>"/>
</form>
<form action="/registration">
    <input type="submit" value="<spring:message key="label.registry"/>"/>
</form>
<a href="?lang=ru">
    <button>RU</button>
</a>
<a href="?lang=en">
    <button>EN</button>
</a>
</body>
</html>