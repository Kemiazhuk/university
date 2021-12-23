<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Teacher courses</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="<spring:message key="label.logout"/>"/>
</form>

<h1><spring:message key="label.coursesInformation"/></h1>
<form method="get" action="journalCourse">
    <table>
        <tr>
            <td><spring:message key="course.name"/></td>
            <td><spring:message key="course.start"/></td>
            <td><spring:message key="course.finish"/></td>
        </tr>
        <c:forEach items="${allCourses}" var="course">
            <tr>
                <td>${course.getCourseName()} </td>
                <td>${course.getStartDate()}</td>
                <td>${course.getEndDate()}</td>
                <td>
                    <button name="id" value="${course.getId()}"><spring:message key="journal.show"/></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value="<spring:message key="label.back"/>"/>
</form>
</body>
</html>