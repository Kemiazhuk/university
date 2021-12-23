<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Registration page </title>
</head>
<body>
<form action="/registration" method="post" modelAttribute="profile">
    <label>
        <spring:message key="registry.name"/> :
        <input type="text" name="login" required/> </label> <br>
    <label>
        <spring:message key="registry.pass"/> : <input type="password" name="password" required/>
    </label> <br>
    <label>
        <spring:message key="registry.firstName"/> : <input type="text" name="firstName" required/>
    </label><br>
    <label>
        <spring:message key="registry.secondName"/> : <input type="text" name="secondName" required/>
    </label><br>
    <label>
        <spring:message key="registry.email"/> : <input type="text" name="email" required/>
    </label><br>
    <label>
        <spring:message key="registry.chooseRole"/> :
        <select id="role" name="role">
            <option value="STUDENT"><spring:message key="role.st"/></option>
            <option value="TEACHER"><spring:message key="role.t"/></option>
        </select>
    </label><br>

    <input type="submit" value=
            "<spring:message key="registry.reg"/>"/>
</form>

<form action="back" method="get">
    <input type="submit" value=<spring:message key="label.back" />>
</form>
</body>
</html>