<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie </title>
    <script type="text/javascript">
        var movie = ${movie};
    </script>
    <script src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
    <script src="<c:url value='/resources/javascript/main.js'/>"></script>
    <script src="<c:url value='/resources/javascript/movie.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/resources/style/bootstrap.min.css'/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value='/resources/style/mainstyle.css'/>" type="text/css" />
</head>
<body>
<div id="mainDiv">
    <div id="menu">
        <nav class="navbar navbar-default navbar-fixed-top" >
            <div class="container">
                <img src="<c:url value='/resources/images/movie_icon.png'/>" width="64" height="64" id="menuImg" style="float: left">


                <form action="/" class="menuButtons">
                    <input type="submit" value="Home" type="button" class="btn btn-info">
                </form>
                <form action="/topGenre" class="menuButtons">
                    <input type="submit" value="Top genre" type="button" class="btn btn-info">
                </form>
                <form action="/search" class="menuButtons">
                    <input type="submit" value="Search" type="button" class="btn btn-info">
                </form>

                <div class=" menuButtons">
                    <button class="btn btn-info" id="movieButton"/> Movie </button>
                </div>

                <span class="menuButtons">
                    <input type="number" class="form-control" placeholder="Enter movie id" id="movieButtonForm">
                </span>

            </div>
        </nav>
    </div>

    <div id="content">

        Welcome

    </div>
</div>

</body>
</html>
