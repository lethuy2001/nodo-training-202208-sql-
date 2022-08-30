<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/29/2022
  Time: 4:55 PM
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
         <sec:authorize access="!hasAnyRole('ROLE_USER')">
             <div> <a href="Trang Chủ"> </a> </div>
         </sec:authorize>

         <sec:authorize access="!hasAnyRole('ROLE_USER')">
             <div> <a href="/dang-nhap" style="margin-left: 30px ;"> Đăng nhập</a> </div>
             <a href="/logout" style="margin-left: 30px;"> Logout </a>
         </sec:authorize>

     </nav>
     <div> Hello Java Class</div>
</body>
</html>
