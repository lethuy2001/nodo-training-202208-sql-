<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/26/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>
        List Student
    </title>
</head>
<body>
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
        <c:forEach items="${lists}" var="cs">
            <tr>
                <td>${cs.id}</td>
                <td>${cs.name}</td>
                <td>${cs.age}</td>
                <td><a href="http://localhost:8080/student/delete/${cs.id}">Delete</a></td>
                <td><a href="http://localhost:8080/student/edit/${cs.id}">edit</a></td>
                <td><a href="javascript:view(${cs.id})">${cs.name}</a></td>
            </tr>
        </c:forEach>
    </table>
</form>


<dialog id="viewStudent" style="width: 50%; border: 1px dotted black ;">
    <div id="content"></div>
    <button id="hide">Close</button>
</dialog>

<script>
    var dialog = document.getElementById('viewStudent') ;
    document.getElementById('hide').onclick = function () {
        dialog.close() ;
    }

    function view( id) {
        let xmlHttp = new XMLHttpRequest() ;
        xmlHttp.open("GET" , "json/" + id , true );
        xmlHttp.onload = function ( ){
            console.log("jascsacs")
            if( this.status != 200 ){
                return ;
            }
            console.log( this.responseText) ;
            var student = JSON.parse(this.responseText) ;
            document.getElementById('content').innerHTML = 'Name: ' + student.name ;
            var dialog = document.getElementById('viewStudent');
            dialog.show();
        }
        xmlHttp.send() ;
    }
</script>
</body>
</html>
