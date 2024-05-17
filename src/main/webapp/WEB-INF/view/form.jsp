<%--
  Created by IntelliJ IDEA.
  User: liudo
  Date: 2024-05-16 11:54:59
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="employeeForm">
    <label>ID:</label><br>
    <input type="text" id="id"><br>
    <label>Name:</label><br>
    <input type="text" id="name"><br>
    <label>Email:</label><br>
    <input type="text" id="email"><br>
    <input type="submit" value="Submit">
</form>
</body>
<script>
  document.getElementById("employeeForm").addEventListener("submit", function(event){
    event.preventDefault();

    var xhr = new XMLHttpRequest();
    var id = document.getElementById('id').value;
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;

    xhr.open("POST", 'addEmployee.jsp', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("id=" + id + "&name=" + name + "&email=" + email);

    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        alert(xhr.responseText);
      }
    }
  });
</script>
</html>
