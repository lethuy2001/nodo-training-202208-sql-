<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/30/2022
  Time: 9:05 AM
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
    <tiles:insertDefinition name="template" >
        <tiles:putAttribute name="body" >
            <h2>${message}</h2>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
