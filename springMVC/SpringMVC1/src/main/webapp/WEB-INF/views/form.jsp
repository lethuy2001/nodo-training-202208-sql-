<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/25/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <form action="http://localhost:8080/student/save" method="get">
           <div>
               <label>Name</label>
               <input type="text" name="name">
           </div>
         <div>
             <label>Age</label>
             <input type="text" name="age">
         </div>
         <div>
              <button> Submit</button>
         </div>
     </form>
</body>
</html>
