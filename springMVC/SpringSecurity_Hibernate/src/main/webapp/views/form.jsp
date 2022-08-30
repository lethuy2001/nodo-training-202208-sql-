<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/30/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tiles:insertDefinition name="template">
          <tiles:putAttribute name="body" >
               <h1>Add Group</h1>
               <form:form method="post" action="/group/new">
                   <input path="name" type="text" name="name">
                   <button>Add</button>
               </form:form>
          </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
