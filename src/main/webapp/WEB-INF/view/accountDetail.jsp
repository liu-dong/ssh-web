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
        <input type="hidden" name="dto.id" value="${vo.id}">
        <div class="form-row">
            <label for="username">用户名：</label>
            <input id="username" type="text" name="dto.username" value="${vo.username}" required>
            <label for="realName">真实姓名：</label>
            <input id="realName" type="text" name="dto.realName" value="${vo.realName}" required>
        </div>
        <div class="form-row">
            <label for="password">密码：</label>
            <input id="password" type="text" name="dto.password" value="${vo.password}" required>
            <label for="confirmPassword">密码确认：</label>
            <input id="confirmPassword" type="text" value="${vo.passwordHash}" readonly>
        </div>
        <div class="form-row">
            <label for="phone">手机号：</label>
            <input id="phone" type="text" name="dto.phone" value="${vo.phone}" required>
            <label for="email">邮箱：</label>
            <input id="email" type="text" name="dto.email" value="${vo.email}" required>
        </div>
        <div class="form-row">
            <label for="userType">用户类型：</label>
            <input id="userType" type="text" name="dto.userType" value="${vo.userType}" required>
            <label for="userStatus">用户状态：</label>
            <input id="userStatus" type="text" name="dto.userStatus" value="${vo.userStatus}" required>
        </div>
        <div class="form-row">
            <label for="lastLoginTime">上次登录时间：</label>
            <input id="lastLoginTime" type="text" name="dto.lastLoginTime" value="${vo.lastLoginTime}" readonly>
            <label for="loginCount">登录次数：</label>
            <input id="loginCount" type="text" name="dto.loginCount" value="${vo.loginCount}" readonly>
        </div>
        <div class="form-button">
            <button type="submit">保存</button>
            <button type="button" onclick="goBack()">返回</button>
        </div>
    </form>
</div>
</body>
<c:if test="${viewType == 'detail'}">
    <script>
      // 设置为只读状态
      window.onload = function() {
        // 获取所有输入元素
        var inputs = document.querySelectorAll('.form input, .form select, .form textarea');

        // 遍历并禁用所有元素
        inputs.forEach(function(input) {
          input.setAttribute('disabled', 'disabled');
        });

        // 隐藏或移除提交按钮
        var submitButton = document.querySelector('.form-button');
        if(submitButton) {
          submitButton.style.display = 'none';
        }
      };
    </script>
</c:if>
<script>
</script>
</html>
