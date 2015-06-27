<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <script type="text/javascript">
        var someValue = ${movie};
    </script>
    <script src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
    <script src="<c:url value='/resources/javascript/movie.js'/>"></script>
</head>
<body>
    Test
${atrj}
</body>
</html>
