<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<button onclick="history.back()">Back to Previous Page</button>
<h1>Error</h1>
<br />
<p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
<p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
<br />
</body>
</html>
