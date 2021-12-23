<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Student page</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="<spring:message key="label.logout"/>"/>
</form>
<h1><spring:message key="greeting.user"/> <c:out value="${pageContext.request.userPrincipal.name}"/> !</h1>
<p>
    <a href="/student-page/profile">
        <button><spring:message key="label.profile"/></button>
    </a>
<p>
    <a href="/student-page/courses/mine">
        <button><spring:message key="student.showMyCourses"/></button>
    </a>
<p>
    <a href="/student-page/courses/add">
        <button><spring:message key="student.showAvailableCourses"/></button>
    </a>
<p>
    <a href="?lang=ru">
        <button>RU</button>
    </a>
    <a href="?lang=en">
        <button>EN</button>
    </a>
</body>
</html>