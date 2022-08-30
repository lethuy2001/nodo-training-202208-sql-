<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/28/2022
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tiles:insertDefinition name="studentTemplate" >
        <tiles:putAttribute name="body" > </tiles:putAttribute>
        <h2>List of Students</h2>
        <form method="get" action="http://localhost:8080/student/findbyname">
            <table border="1">
               <tr>
                  <td colspan="4"> <input type="text" name="data" style="width: 100%;" /> </td>
                  <td colspan="2"> <button style="width: 100%;">Submit</button></td>
               </tr>
                <tr>
                   <td>Id</td>
                   <td>Name</td>
                   <td>Age</td>
                   <td></td>
                   <td></td>
                   <td></td>
                </tr>
                <c:forEach items="${list}" var="cs">
                  <tr>
                    <td>${cs.id}</td>
                    <td>${cs.name}</td>
                    <td>${cs.age}</td>
                    <td><a href="http://localhost:8080/student/delete/${cs.id}">Delete</a></td>
                    <td><a href="http://localhost:8080/student/edit/${cs.id}">edit</a></td>
                   </tr>
                 </c:forEach>
        </table>
    </tiles:insertDefinition>
</form>
</body>
</html>
