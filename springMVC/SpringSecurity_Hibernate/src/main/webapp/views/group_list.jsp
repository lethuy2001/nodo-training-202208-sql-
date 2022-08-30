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
                      <td>Name</td>
                      <td>#</td>
                  </tr>
                  <c:forEach var="x" items="${groups}">
                       <tr>
                           <td>${x.name}</td>
                           <td> <a href="/group/delete/${x.id}">Xóa</a> </td>
                       </tr>
                  </c:forEach>
              </table>
          </tiles:putAttribute>
     </tiles:insertDefinition>
</body>
</html>
