<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload result</title>
</head>
<body>
${upload_result}
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="commandType" value="existing_files_display_command">
    <input type="submit" value="show quadrangles"/>
</form>
</body>
</html>
