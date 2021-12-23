<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1>Information about course</h1>
<table>
    <tr class="w3-hover-blue">
        <td>Name course</td>
        <td>Course started</td>
        <td>Course ended</td>
    </tr>
    <tr>
        <c:set var="course" value="${course}"/>
        <td>${course.getCourseName()}</td>
        <td>${course.getStartDate()}</td>
        <td>${course.getEndDate()}</td>
    </tr>
</table>
<form method="post">
    <div class="input-box">
        <input type="submit" name="add course" value="addCourse">
    </div>
</form></body>
</html>