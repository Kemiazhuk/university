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
    <input type="submit" value="<spring:message key="label.logout"/>">
</form>
<h1><spring:message key="journal"/></h1>
<form action="editJournal" method="post">
<table>
    <tr>
        <td align="center"><spring:message key="course.name" /></td>
        <td align="center"><spring:message key="course.start" /></td>
        <td align="center"><spring:message key="course.finish" /></td>
        <td align="center"><spring:message key="journal.studentName"/></td>
        <td align="center"><spring:message key="journal.mark" /></td>
        <td align="center"><spring:message key="journal.review" /></td>
        <td/>
    </tr>
    <c:forEach items="${journal}" var="journal">
        <tr>
            <td align="center">${journal.getCourseName()}</td>
            <td align="center">${journal.getStartDate()}</td>
            <td align="center">${journal.getEndDate()}</td>
            <td align="center">${journal.getFirstNameStudent()}
                    ${journal.getSecondNameStudent()}</td>
            <td align="center">${journal.getMark()}</td>
            <td align="center">${journal.getReview()}</td>
            <td align="center">
                <button name="id" value="${journal.getId()}"> <spring:message key="journal.edit" /></button>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
<form action="back" method="get">
    <input type="submit" value=<spring:message key="label.back" />>
</form>
</body>
</html>