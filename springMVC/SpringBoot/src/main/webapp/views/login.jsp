<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/29/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h1>Login to application</h1>
      <c:if test="${not empty error }">
           <div class="error">${error}</div>
      </c:if>
      <form method="post" action="/login">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          <input type="text" name="username" placeholder="username">
          <input type="text" name="password" placeholder="password">
          <button>Submit</button>
      </form>
</body>
</html>
