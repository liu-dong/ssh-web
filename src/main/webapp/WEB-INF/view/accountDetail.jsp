<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号详情</title>
    <link rel="stylesheet" type="text/css" href="${_path}/css/list.css"/>
    <script type="text/javascript" src="${_path}/js/list.js"></script>
</head>
<body>
<div class="content-container">
    <form class="form" action="<%=request.getContextPath()%>/save" method="POST">
        <div class="form-row">
            <label for="oldPassword">当前密码：</label>
            <input type="password" id="oldPassword" name="updatePasswordDTO.oldPassword" required>
        </div>
        <div class="form-row">
            <label for="newPassword">新密码：</label>
            <input type="password" id="newPassword" name="updatePasswordDTO.newPassword" required>
        </div>
        <div class="form-row">
            <label for="confirmPassword">确认新密码：</label>
            <input type="password" id="confirmPassword" name="updatePasswordDTO.confirmPassword" required>
        </div>
        <div class="form-button">
            <button type="submit">修改密码</button>
        </div>
    </form>
</div>
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
