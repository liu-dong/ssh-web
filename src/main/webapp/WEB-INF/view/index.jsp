<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/form.css"/>
    <link rel="stylesheet" type="text/css" href="css/modal.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="header-logo"></div>
        <div class="header-toolbar">
            <ul class="nav-list">
                <li>您好，${userDetail.realName}！</li>
                <li><a href="#" onclick="loadContentInIframe('${_path}/navigate?page=home')">首页</a></li>
                <li><a href="#" onclick="togglePasswordForm()">修改密码</a></li>
                <li><a href="<%=request.getContextPath()%>/logout">退出</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="menu">
            <ul class="menu-list">
                <%-- <li>账号管理
                    <ul>
                        <li>子菜单项1</li>
                        <li>子菜单项2</li>
                    </ul>
                </li> --%>
                <li><a href="#" onclick="loadContentInIframe('${_path}/account/list')">账号管理</a></li>
                <li><a href="#" onclick="loadContentInIframe('${_path}/role/list')">角色管理</a></li>
                <li><a href="#" onclick="loadContentInIframe('${_path}/permission/list')">权限管理</a></li>
                <li><a href="#" onclick="loadContentInIframe('${_path}/org/list')">单位管理</a></li>
                <li><a href="#" onclick="loadContentInIframe('${_path}/person/list')">人员管理</a></li>
            </ul>
        </div>
        <div class="main-container">
            <div class="content">
                <iframe id="contentFrame" style="width: 100%; height: 100%; border: none;"></iframe>
            </div>
            <div class="footer">
                Copyright © 2024 LD
            </div>
        </div>
    </div>
    <!-- 新增遮罩层 -->
    <div id="modalBackground" class="modal-background hidden"></div>
    <!-- 弹窗 -->
    <div id="modalPassword" class="modal hidden">
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
  //打开关闭弹窗
  function togglePasswordForm() {
    var modal = document.getElementById('modalPassword');
    var modalBg = document.getElementById('modalBackground');
    modal.classList.toggle('hidden');
    modalBg.classList.toggle('hidden');
  }

  //加载iframe
  function loadContentInIframe(url) {
    var iframe = document.getElementById('contentFrame');
    iframe.src = url;
  }
</script>
</html>
