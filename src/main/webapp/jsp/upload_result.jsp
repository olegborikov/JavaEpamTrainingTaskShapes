<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload result</title>
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <script type="text/javascript" src="js\bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <hr/>
    ${uploadResult}
    <hr/>
    <form action="quadrangle" method="post">
        <input type="hidden" name="commandName" value="existing_files_display_command">
        <input type="submit" value="show quadrangles"/>
    </form>
    <hr/>
    <button onclick="history.back()">Previous Page</button>
    <hr/>
</div>
</body>
</html>
