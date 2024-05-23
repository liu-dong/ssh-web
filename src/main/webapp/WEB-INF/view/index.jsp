<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/form.css"/>
<link rel="stylesheet" type="text/css" href="css/modal.css"/>
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
    <div id="modalBackground" class="modal-background hidden"></div> <!-- 新增遮罩层 -->
    <div id="modalPassword" class="modal hidden"> <!-- 用于弹窗的新Div -->
        <div class="modal-content">
            <span class="close-button" onclick="togglePasswordForm()">&times;</span> <!-- 关闭按钮 -->
            <h2>修改密码</h2>
            <form class="form" action="<%=request.getContextPath()%>/updatePassword" method="POST">
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
    </div>
</div>
</body>
<script>
  function togglePasswordForm() {
    debugger
    var modal = document.getElementById('modalPassword');
    var modalBg = document.getElementById('modalBackground');
    modal.classList.toggle('hidden');
    modalBg.classList.toggle('hidden');
  }
</script>
</html>
