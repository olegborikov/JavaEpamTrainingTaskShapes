<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    td {
        text-align: center;
    }
</style>
<html>
<head>
    <title>Quadrangle Output</title>
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <script type="text/javascript" src="js\bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <hr/>
    <h5>${fileName}</h5>
    <hr/>
    <c:choose>
        <c:when test="${not empty quadrangles}">
            <table border="1">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Id</th>
                    <th>Point 1</th>
                    <th>Point 2</th>
                    <th>Point 3</th>
                    <th>Point 4</th>
                    <th>isConvex</th>
                    <th>isSquare</th>
                    <th>isRhombus</th>
                    <th>isTrapezoid</th>
                    </form>
                </tr>
                </thead>
                <tbody>
                <c:set var="i" value="1"/>
                <c:forEach var="q" items="${quadrangles}">
                    <tr>
                        <td>${i}</td>
                        <td>${q.quadrangleId}</td>
                        <td>(${q.point1.x},${q.point1.y})</td>
                        <td>(${q.point2.x},${q.point2.y})</td>
                        <td>(${q.point3.x},${q.point3.y})</td>
                        <td>(${q.point4.x},${q.point4.y})</td>
                            <%--  <td>
                                  <form action="controller" method="get">
                                      <input type="submit" value="check"/>
                                  </form>
                              </td>--%>
                        <td>
                            <button>Check</button>
                        </td>
                        <td>
                            <button>Check</button>
                        </td>
                        <td>
                            <button>Check</button>
                        </td>
                        <td>
                            <button>Check</button>
                        </td>
                    </tr>
                    <c:set var="i" value="${i+1}"/>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h5>${fileName} is empty</h5>
        </c:otherwise>
    </c:choose>

    <hr/>
    <button onclick="history.back()">Previous Page</button>
    <hr/>
</div>
</body>
</html>


