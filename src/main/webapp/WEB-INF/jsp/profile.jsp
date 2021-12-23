<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="<spring:message key="label.logout"/>"/>
</form>

<h1><spring:message key="profile.intro"/></h1>
<c:set var="student" value="${user}"/>
<form method="post" action="profile/edit" modelAttribute="profile">
    <table>
        <tr>
            <td></td>
            <td><spring:message key="profile.your"/></td>
            <td><spring:message key="profile.change"/></td>
        </tr>
        <tr>
            <td><spring:message key="registry.pass"/></td>
            <td>********</td>
            <td><input type="password" name="password" placeholder="<spring:message key="registry.pass"/>" required></td>
        </tr>
        <tr>
            <td><spring:message key="registry.firstName"/></td>
            <td>${user.getFirstName()}</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td><spring:message key="registry.secondName"/></td>
            <td>${user.getSecondName()}</td>
            <td><input type="text" name="secondName"></td>
        </tr>
        <tr>
            <td><spring:message key="registry.email"/></td>
            <td>${user.getEmail()}</td>
            <td><input type="text" name="Email"></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="<spring:message key="profile.save"/>"></td>
        </tr>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value="<spring:message key="label.back"/>"/>
</form>
</body>
</html>