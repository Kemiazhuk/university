<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org" xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>University app</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

<h1>Welcome to university application! ${userName} </h1>

<h2>Hi <span th:text="${userName}"></span> </h2>

<h2>Hi <title th:text="${userName}"></title> </h2>

<p>if you want to see all courses click <a href="/courses/all">here</a> </p>


</body>
</html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %><!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Add course</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="<spring:message key="label.logout"/>"/>
</form>

<h1><spring:message key="student.availableCourses"/></h1>
<form method="post" action="add/save">
    <table>
        <tr>
            <td><spring:message key="course.name"/></td>
            <td><spring:message key="course.start"/></td>
            <td><spring:message key="course.finish"/></td>
        </tr>
        <c:forEach items="${allCourses}" var="course">
            <tr>
                <td> ${course.getCourseName()} </td>
                <td><c:out value="${course.getStartDate()}"/></td>
                <td><c:out value="${course.getEndDate()}"/></td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <input type="submit" value=<spring:message key="student.addForStudy"/>
                        </td>
        </tr>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value="<spring:message key="label.back"/>"/>
</form>
</body>
</html>