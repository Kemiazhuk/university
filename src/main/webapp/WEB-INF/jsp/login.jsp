<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Login page</title>
</head>
<body>
<form method="post" action="/login">
    <h2><spring:message key="label.login"/></h2> <br>
    <input type="text" name="username" placeholder=
            "<spring:message key="label.userName"/>" required><br>
    <input type="password" name="password" placeholder=
            "<spring:message key="label.password"/>" required><br>
        <%--                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" --%>
        <%--                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" --%>
    <input type="submit" name="sign-in" value="<spring:message key="label.login"/>"> <br>
    <a href="/registration"><spring:message key="label.goRegistry"/></a>
</form>
</body>
</html>