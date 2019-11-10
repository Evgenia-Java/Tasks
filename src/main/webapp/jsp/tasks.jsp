
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<form action = "/tasks" method="get">
StartDate <input type="string" name="startDate" size="10" placeholder="yyyy-MM-dd" value="${startDate}"><br>
EndDate <input type="string" name="endDate" size="10" placeholder="yyyy-MM-dd" value="${endDate}"><br>
Assignee <input type="string" name="assignee" value="${assignee}"><br>
Period <select name="period">
    <option>Last Quarter</option>
    <option value="Last Quarter">lastQuarter</option>
    <option value="Last Month">lastMonth</option>
    <option value="Last Week">lastWeek</option>
    <option value="Current Quarter to Date">currentQuartertoDate</option>
    <option value="Current Month to Date">currentMonthtoDate</option>
    <option value="Current Week to Date">currentWeektoDate</option>
</select>


<table>
    <tr>
        <th><small>
            <input type="submit" name="findTask" value="Find">
        </small>
</table>


</form>
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
