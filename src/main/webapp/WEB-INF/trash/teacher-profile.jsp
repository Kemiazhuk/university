<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

<h1>Profile information</h1>
<c:set var="student" value="${user}"/>
<c:set var="account" value="${account}"/>
<form method="post" action="profile/edit" modelAttribute="profile" >
    <table>
        <tr>
            <td></td>
            <td>Your profile</td>
            <td>Change on</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>********</td>
            <td><input type="password" name="password" placeholder="password" required> </td>
        </tr>
        <tr>
            <td>First name</td>
            <td>${teacher.getFirstName()}</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Second name</td>
            <td>${teacher.getSecondName()}</td>
            <td><input type="text" name="secondName"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${teacher.getEmail()}</td>
            <td><input type="text" name="Email"></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="Save changes"></td>
        </tr>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value="Back"/>
</form>
</body>
</html>