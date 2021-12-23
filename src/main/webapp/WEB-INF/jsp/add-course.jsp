<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Add course</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="<spring:message key="label.logout"/>"/>
</form>

<h1><spring:message key="teacher.createCourse"/></h1>
<form method="post" action="add/save" modelAttribute="profile">
    <table>
        <tr>
            <td><spring:message key="course.name"/></td>
            <td><spring:message key="course.start"/></td>
            <td><spring:message key="course.finish"/></td>
        </tr>
        <tr>
            <td><input type="text" name="courseName"></td>
            <td><input value="2020-10-10" type="text" name="startDate"></td>
            <td><input value="2020-12-12" type="text" name="endDate"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value=
                <spring:message key="teacher.add"/>>
            </td>
        </tr>
    </table>
</form>
<form action="back" method="get">
    <input type="submit" value="<spring:message key="label.back"/>"/>
</form>
</body>
</html>