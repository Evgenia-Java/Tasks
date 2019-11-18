<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create task</title>
<%--    <link rel="stylesheet" href="../../jqwidgets/styles/jqx.base.css" type="text/css"/>--%>
<%--    <script type="text/javascript" src="../../scripts/jquery-1.11.1.min.js"></script>--%>
<%--    <script type="text/javascript" src="../../jqwidgets/jqxcore.js"></script>--%>
<%--    <script type="text/javascript" src="../../jqwidgets/jqxdatetimeinput.js"></script>--%>
<%--    <script type="text/javascript" src="../../jqwidgets/jqxcalendar.js"></script>--%>
<%--    <script type="text/javascript" src="../../jqwidgets/globalization/globalize.js"></script>--%>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
    <style type="text/css">
        input {width: 200px; text-align: left}
    </style>
    <script type="text/javascript">
        $(function() {

            $('#dateStart').datepicker({
                format: "yyyy/MM/dd"
            });

        });
    </script>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
    <style type="text/css">
        input {width: 200px; text-align: left}
    </style>
    <script type="text/javascript">
        $(function() {

            $('#dateEnd').datepicker({
                format: "yyyy/MM/dd"
            });

        });
    </script>
</head>
<body>
<form action="/createTask" method="post">
    Summary <input type="text" name="summary"><br>
    Assignee <input type="text" name="assignee"><br>
    <form>
        <div class="ui-widget">
            <label for="dateStart">Start Date </label><input type="text" id="dateStart" pattern="yyyy/MM/dd" placeholder="yyyy/MM/dd"/>
        </div>
    </form>
    <form>
        <div class="ui-widget">
            <label for="dateEnd">End Date </label><input type="text" id="dateEnd" pattern="yyyy/MM/dd" placeholder="yyyy/MM/dd"/>
        </div>
    </form>
    <p>

    <table>
        <tr>
            <th><small>
                <input type="submit" name="createTask" value="Add new Task" >
            </small>
    </table>
</form>
</body>
</html>
