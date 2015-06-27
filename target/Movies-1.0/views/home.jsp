<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <script type="text/javascript">
        var someValue = ${atrj};
    </script>
    <script src="<c:url value='/resources/javascript/test.js'/>"></script>
</head>
<body>
    Test
${atrj}

    <%--<script type="text/javascript">--%>
        <%--var data = ${atrj};--%>
        <%--console.log(data);--%>
    <%--</script>--%>
</body>
</html>
