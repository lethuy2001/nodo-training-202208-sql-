<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/30/2022
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> Welcome to Spring jazz</h1>
    <a href="/home">Trang Chủ</a>
    <sec:authorize access="!hasAnyAuthority('USER')" >
        <a href="/login" style="margin-left: 30px ;">Đăng nhập</a>
    </sec:authorize>

    <sec:authorize access="hasAnyAuthority('USER')" >
        <a href="/nguoi-dung" style="margin-left: 30px ;">Người dùng</a>
<%--        <a href="/logout_security" style="margin-left: 30px ;"> Đăng xuất</a>--%>
        <form action="/logout_security" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button>Đăng xuất</button>
        </form>
    </sec:authorize>


    <tiles:insertAttribute name="body" ></tiles:insertAttribute>
</body>
</html>
