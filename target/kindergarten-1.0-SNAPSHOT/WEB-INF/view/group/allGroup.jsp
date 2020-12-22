<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Welcome!</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
    <a class="navbar-brand" href="/">KG</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/groups">Groups</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/children">Children</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/teachers">Teachers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/classes">Extra classes</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>All groups:</h1>
    <a class="btn btn-primary btn-block mb-3" href="${pageContext.request.contextPath}/addGroup">Add new group</a>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Min age</th>
            <th scope="col">Max age</th>
            <th scope="col">Change</th>
            <th scope="col">Children</th>
            <th scope="col">Teachers</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach var="group" items="${groups}">
            <tr>
                <form action="${pageContext.request.contextPath}/groups" method="POST" class="form-inline">
                    <th scope="row"><c:out value="${group.getId()}"/></th>

                    <td><input type="text" value="<c:out value="${group.getName()}"/>" name="groupName"/></td>
                    <td><input type="text" value="<c:out value="${group.getMinAge()}"/>" name="minAge"/></td>
                    <td><input type="text" value="<c:out value="${group.getMaxAge()}"/>" name="maxAge"/></td>
                    <td>
                        <input type="hidden" value="${group.getId()}" name="groupId">
                        <button type="submit" class="btn btn-warning">Apply</button>
                    </td>
                </form>
                <td>
                    <form action="${pageContext.request.contextPath}/group/children" method="GET" class="form-inline">
                        <button type="submit" class="btn btn-primary">Children</button>
                        <input type="hidden" value="${group.getId()}" name="groupId">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/group/teachers" method="GET" class="form-inline">
                        <button type="submit" class="btn btn-success">Teachers</button>
                        <input type="hidden" value="${group.getId()}" name="groupId">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/deleteGroup" method="POST" class="form-inline">
                        <button type="submit" class="btn btn-danger">Delete</button>
                        <input type="hidden" value="${group.getId()}" name="groupId">
                    </form>

                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>


</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</body>
</html>