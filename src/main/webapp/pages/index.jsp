<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>index</title>
    </head>
    <body>
        <h1>hello</h1>
        <form action="/user/save" method="post" enctype="multipart/form-data">
            <%--@RequestParam String name--%>
            <input type="" name="name" placeholder="name">
            <%--@RequestParam("age") int age--%>
            <input type="number" name="age" placeholder="age">
            <input type="file" name="ava" placeholder="ava">
            <input type="email" name="email" placeholder="email">

            <input type="submit" name="" placeholder="">

        </form>


        <%--<sf:form action="/user/saveSF" method="post" modelAttribute="xxx">--%>
        <%--<sf:input path="name"/>--%>
        <%--<sf:input path="age"/>--%>
        <%--<sf:errors path="age"/>--%>
        <%--<sf:select path="cars">--%>
        <%--<c:forEach items="${cars}" var="car">--%>

        <%--<sf:option value="${car.id}">${car.model}</sf:option>--%>
        <%--</c:forEach>--%>
        <%--</sf:select>--%>

        <%--<input type="submit" name="" placeholder="">--%>
        <%--</sf:form>--%>


        <%--<sf:form modelAttribute="yyy" action="/saveCar" method="post">--%>
        <%--<sf:input path="model"/>--%>
        <%--<sf:input path="vol"/>--%>
        <%--<sf:select path="user">--%>
        <%--<c:forEach items="${users}" var="user">--%>
        <%--<sf:option value="${user.id}">${user.name}</sf:option>--%>
        <%--</c:forEach>--%>

        <%--</sf:select>--%>
        <%--<input type="submit" name="" placeholder="">--%>

        <%--</sf:form>--%>


        <%--<form action="/saveImg" method="post" enctype="multipart/form-data">--%>
        <%--<input type="file" name="picture" placeholder="pictire">--%>
        <%--<input type="submit" name="" placeholder="">--%>

        <%--</form>--%>


    </body>
</html>
