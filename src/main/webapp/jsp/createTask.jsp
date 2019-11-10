<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create task</title>
</head>
<body>
<form action="/createtask" method="get">
    Summary <input type="string" name="summary"><br>
    Assignee <input type="string" name="assignee"><br>
    //Календарь    Start Date <input type="date" name="startDate"><br>
    //Календарь    End Date <input type="date" name="endDate"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="createTask" value="Add new Task">    //Открытие страницы с поиском задач
            </small>
    </table>
</form>
</body>
</html>
