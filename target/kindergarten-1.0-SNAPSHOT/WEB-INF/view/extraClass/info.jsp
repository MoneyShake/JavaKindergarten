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

    <center><h1>Extra class: <c:out value="${extraClassName}"/> </h1></center>

    <h1>Teachers:</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">FirstName</th>
            <th scope="col">Last name</th>
            <th scope="col">Sex</th>
            <th scope="col">Change</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="teacher" items="${teachers}">
            <tr>
                <form action="${pageContext.request.contextPath}/teachers" method="POST" class="form-inline">
                    <th scope="row"><c:out value="${teacher.getId()}"/></th>

                    <td><input type="text" value="<c:out value="${teacher.getFirstName()}"/>" name="firstName"/></td>
                    <td><input type="text" value="<c:out value="${teacher.getLastName()}"/>" name="lastName"/></td>
                    <td><input type="text" value="<c:out value="${teacher.getSex()}"/>" name="sex"/></td>
                    <td>
                        <input type="hidden" value="${teacher.getId()}" name="teacherId">
                        <button type="submit" class="btn btn-warning">Apply</button>
                    </td>
                </form>
                <td>
                    <form action="${pageContext.request.contextPath}/teachers/deleteFromExtraClass" method="POST" class="form-inline">
                        <button type="submit" class="btn btn-danger">Delete from class</button>
                        <input type="hidden" value="${teacher.getId()}" name="teacherId">
                        <input type="hidden" value="${extraClassId}" name="extraClassId">
                    </form>

                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

    <h1>Children:</h1>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">FirstName</th>
            <th scope="col">Last name</th>
            <th scope="col">Sex</th>
            <th scope="col">Group id</th>
            <th scope="col">Change</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach var="teacher" items="${children}">
            <tr>
                <form action="${pageContext.request.contextPath}/children" method="POST" class="form-inline">
                    <th scope="row"><c:out value="${teacher.getId()}"/></th>

                    <td><input type="text" value="<c:out value="${teacher.getFirstName()}"/>" name="firstName"/></td>
                    <td><input type="text" value="<c:out value="${teacher.getLastName()}"/>" name="lastName"/></td>
                    <td><input type="text" value="<c:out value="${teacher.getSex()}"/>" name="sex"/></td>
                    <td><input type="text" value="<c:out value="${teacher.getGroupId()}"/>" name="groupId"/></td>

                    <td>
                        <input type="hidden" value="${teacher.getId()}" name="childId">
                        <button type="submit" class="btn btn-warning">Apply</button>
                    </td>
                </form>
                <td>
                    <form action="${pageContext.request.contextPath}/children/deleteFromExtraClass" method="POST" class="form-inline">
                        <button type="submit" class="btn btn-danger">Del. from class</button>
                        <input type="hidden" value="${teacher.getId()}" name="childId">
                        <input type="hidden" value="${extraClassId}" name="extraClassId">
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