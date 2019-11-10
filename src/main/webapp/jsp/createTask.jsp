<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create task</title>
</head>
<body>
<form action="/createTask" method="get">
    Summary <input type="string" name="summary"><br>
    Assignee <input type="string" name="assignee"><br>
    Start Date <input type="string" name="startDate" placeholder="yyyy-MM-dd"><br>
    End Date <input type="string" name="endDate" placeholder="yyyy-MM-dd"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="createTask" value="Add new Task">
            </small>
    </table>
</form>
</body>
</html>
