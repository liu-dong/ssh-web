<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<style>


</style>
<body>
<div class="container">
    <div class="header">
        <div class="header-logo"></div>
        <div class="header-toolbar">
            <ul class="nav-list">
                <li>您好，${userDetail.realName}！</li>
                <li><a href="<%=request.getContextPath()%>/index">首页</a></li>
                <li><a onclick="togglePasswordForm()">修改密码</a></li>
                <li><a href="<%=request.getContextPath()%>/logout">退出</a></li>
            </ul>
            <div id="passwordForm" class="hidden">
                <form action="<%=request.getContextPath()%>/updatePassword" method="POST">
                    <div>
                        <label for="oldPassword">当前密码：</label>
                        <input type="password" id="oldPassword" name="oldPassword" required>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" id="newPassword" name="newPassword" required>
                    </div>
                    <div>
                        <label for="confirmPassword">确认新密码：</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required>
                    </div>
                    <div>
                        <button type="submit">修改密码</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="menu">
            <ul class="menu-list">
                <li>账号管理
                    <ul>
                        <li>子菜单项1</li>
                        <li>子菜单项2</li>
                    </ul>
                </li>
                <li>角色管理</li>
                <li>权限管理</li>
                <li>单位管理</li>
                <li>人员管理</li>
            </ul>
        </div>
        <div class="main-container">
            <div class="content">
                <h2>Hello World!</h2>
                <h2>您好，${session_user.realName}！</h2>
            </div>
            <div class="footer">
                Copyright © 2024 LD
            </div>
        </div>
    </div>
</div>
</body>
<script>
  function togglePasswordForm() {
    // 获取表单元素
    var form = document.getElementById('passwordForm');

    // 切换表单的显示状态
    if (form.classList.contains('hidden')) {
      form.classList.remove('hidden');
      form.classList.add('visible');
    } else {
      form.classList.remove('visible');
      form.classList.add('hidden');
    }
  }
</script>
</html>
