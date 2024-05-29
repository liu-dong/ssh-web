<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账号详情</title>
    <link rel="stylesheet" type="text/css" href="${_path}/css/form.css"/>
    <script type="text/javascript" src="${_path}/js/form.js"></script>
</head>
<body>
<div class="content-container">
    <h2>账号详情页</h2>
    <form class="form" action="<%=request.getContextPath()%>/saveAccount" method="POST">
        <div class="form-row">
            <label for="username">用户名：</label>
            <input id="username" type="text" name="dto.username" required>
            <label for="realName">真实姓名：</label>
            <input id="realName" type="text" name="dto.realName" required>
        </div>
        <div class="form-row">
            <label for="password">密码：</label>
            <input id="password" type="password" name="dto.password" required>
            <label for="confirmPassword">密码确认：</label>
            <input id="confirmPassword" type="password" required>
        </div>
        <div class="form-row">
            <label for="phone">手机号：</label>
            <input id="phone" type="text" name="dto.phone" required>
            <label for="email">邮箱：</label>
            <input id="email" type="text" name="dto.email" required>
        </div>
        <div class="form-row">
            <label for="userType">用户类型：</label>
            <input id="userType" type="text" name="dto.userType" required>
            <label for="userStatus">用户状态：</label>
            <input id="userStatus" type="text" name="dto.userStatus" required>
        </div>
        <div class="form-row">
            <label for="lastLoginTime">上次登录时间：</label>
            <input id="lastLoginTime" type="text" name="dto.lastLoginTime" required>
            <label for="loginCount">登录次数：</label>
            <input id="loginCount" type="text" name="dto.loginCount" required>
        </div>

        <div class="form-button">
            <button type="submit">保存</button>
            <button type="button" onclick="goBack()">返回</button>
        </div>
    </form>
</div>
</body>
<script>
</script>
</html>
