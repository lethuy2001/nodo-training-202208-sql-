<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/31/2022
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body" >
        <h1>Add User</h1>
        <form:form method="post" action="/acc/save" modelAttribute="command">
            <div>Tên: <form:input path="username" name="username" type="text"/></div>
            <div>Mật Khẩu: <form:input path="password" name="password" type="text"/></div>
            <div>Email: <form:input path="email" name="email" type="text"/></div>
            <div>Tuổi: <form:input path="age" name="age" /></div>
            <div>Nhóm: <form:select path="group" name="group"  >
                             <form:options items="${groups}"></form:options>
                       </form:select> </div>
            <button>Add</button>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
</body>
</html>
