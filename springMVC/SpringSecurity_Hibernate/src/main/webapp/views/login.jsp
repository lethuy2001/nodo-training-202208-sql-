<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/30/2022
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <tiles:insertDefinition name="template">
      <tiles:putAttribute name="body">
          <h1>Trang đăng nhập</h1>
          <c:if test="${not empty error}">
              <p>Sai tên đăng nhập hoặc mật khẩu</p>
          </c:if>
        <form method="post" action="/check_security">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="text" id="username" name="username" placeholder="Username">
             <input type="text" id="password" name="password" placeholder="Password">
             <button>Submit</button>
        </form>
      </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
