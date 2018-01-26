<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page One</title>
</head>
<body>
    <div> The Context Path is ${contextPath}</div>
    <div>
        <a href="${pageContext.servletContext.contextPath}">Index Page</a>
    </div>
</body>
</html>
