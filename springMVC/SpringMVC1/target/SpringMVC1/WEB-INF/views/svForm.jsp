<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/25/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <h2>Pleace input Student Information</h2>

      <form:form action="http://localhost:8080/student/info" method="post" >
          <table>
              <tr>
                  <td>Name:</td>
                  <td><form:input path="name" /></td>
                  <td><forn:errors path="name"></forn:errors></td>
              </tr>
              <tr>
                  <td>Age:</td>
                  <td><form:input path="age"  /> </td>
                  <td><forn:errors path="age"></forn:errors></td>
              </tr>
              <tr>
                  <td colspan="2"> <button> Submit </button> </td>
              </tr>
          </table>
      </form:form>

</body>
</html>
