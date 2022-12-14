<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/30/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tiles:insertDefinition name="template" >
    <tiles:putAttribute name="body">
        <h1>Group list</h1>
        <table>
            <tr>
                <td colspan="3">
                    <form method="get" action="/group/listByName">
                        <input type="text" name="q">
                        <button>Search</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Username</td>
                <td>Password</td>
                <td>Email</td>
                <td>Age</td>
                <td colspan="2">#</td>
            </tr>
            <c:forEach var="x" items="${users}">
                <tr>
                    <td>${x.username}</td>
                    <td>${x.password}</td>
                    <td>${x.email}</td>
                    <td>${x.age}</td>
<%--                    <td>${x.groupId}</td>--%>
                    <td> <a href="/group/delete/${x.username}">Delete</a> </td>
                    <td> <a href="/group/edit/${x.username}"> Edit </a> </td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>
</body>
</html>
