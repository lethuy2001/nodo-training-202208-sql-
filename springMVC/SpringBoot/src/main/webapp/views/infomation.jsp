<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/29/2022
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav>
    <a href="/">Trang Chủ</a>
    <sec:authorize access="!hasAnyRole('USER')">
        <div> <a href="/dang-nhap">Đăng nhập</a> </div>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('USER')">
        <div> <a href="/nguoi-dung" style="margin-left: 30px ;"> Cá nhân</a> </div>
        <a href="/logout" style="margin-left: 30px;"> Logout </a>
    </sec:authorize>
</nav>
   <h2>${message}</h2>
</body>
</html>
