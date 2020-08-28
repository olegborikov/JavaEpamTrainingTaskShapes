<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quadrangle menu</title>
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <script type="text/javascript" src="js\bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <hr/>
    Uploads
    <form action="/upload" enctype="multipart/form-data" method="post">
        <input type="hidden" name="commandName" value="upload_txt_file_command">
        Upload File: <input type="file" name="content" accept="text/plain">
        <input type="submit" value="Upload File">
    </form>
    <hr/>
    <form action="quadrangle" method="post">
        <input type="hidden" name="commandName" value="existing_files_display_command">
        <input type="submit" value="show quadrangles"/>
    </form>
    <hr/>
    <form action="quadrangle" method="post">
        <input type="hidden" name="commandName" value="REPOSITORY_DISPLAY_COMMAND">
        <input type="submit" value="show repository"/>
    </form>
    <hr/>
    <form action="quadrangle" method="post">
        <input type="hidden" name="commandName" value="logout_command">
        <input type="submit" value="Logout"/>
    </form>
    <hr/>
</div>
</body>
</html>
