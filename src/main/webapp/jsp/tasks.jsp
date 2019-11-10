
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center" border="3" width="50%" cellpadding="1">
        <tr align="center">
            <td><b>ID</b></td>
            <td><b>Summary</b></td>
            <td><b>Start Date</b></td>
            <td><b>End Date</b></td>
            <td><b>Assignee</b></td>
        </tr>
        <c:forEach var="task" items="${taskList}">
            <tr align="center">
                <td>${task.id}</td>
                <td>${task.summary}</td>
                <td>${task.startDate}</td>
                <td>${task.endDate}</td>
                <td>${task.assignee}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
