<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1><spring:message key="journal"/></h1>
<c:set var="journal" value="${journal}"/>
<form action="editJournal/save" method="post" modelAttribute="journalCourse">
    <table>
        <tr>
            <td align="center"><spring:message key="course.name"/></td>
            <td align="center">${journal.getCourseName()}</td>
        </tr>
        <tr>
            <td align="center"><spring:message key="course.start"/></td>
            <td align="center">${journal.getStartDate()}</td>
        </tr>
        <tr>
            <td align="center"><spring:message key="course.finish"/></td>
            <td align="center">${journal.getEndDate()}</td>
        </tr>
        <tr>
            <td align="center"><spring:message key="journal.studentName"/></td>
            <td align="center">
                ${journal.getFirstNameStudent()} ${journal.getSecondNameStudent()}
            </td>
        </tr>
        <tr>
            <td align="center"><spring:message key="journal.mark"/></td>
            <td>
                <input
                <c:if test="${journal.getMark() != null}">
                        value=${journal.getMark()}
                        </c:if>
                                type="text" name="mark"></td>
        </tr>
        <tr>
            <td align="center"><spring:message key="journal.review"/></td>
            <td>
                <input
                <c:if test="${journal.getReview() != null}">
                        value=${journal.getReview()}
                        </c:if>
                                type="text" name="review"></td>
        </tr>
        <tr>
            <td/>
            <td>
                <button name="id" value="${journal.getId()}"><spring:message key="journal.edit"/></button>
            </td>
        </tr>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value=<spring:message key="label.back"/>>
</form>
</body>
</html>