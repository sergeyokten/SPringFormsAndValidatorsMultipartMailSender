<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>allUsers</title>
    </head>
    <body>


        <c:forEach items="${users}" var="user">
            <div>
                <h3>${user.name}</h3>
                <p>${user.age}</p>
                <img src="${user.avatar}" alt="">
                <%--/avax/asdasd.jpg--%>

            </div>


        </c:forEach>


    </body>
</html>
