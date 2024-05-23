<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<style>

</style>
<body>
<div class="container">
    <h1>登录页面</h1>
    <form id="login-form" action="<%=request.getContextPath()%>/login" method="post">
        <div class="login-row">
            <label for="username">用户名:</label>
            <input type="text" name="username" id="username">
        </div>
        <div class="login-row">
            <label for="password">密&nbsp;&nbsp;&nbsp;码:</label>
            <input type="password" name="password" id="password">
        </div>
        <div class="login-button">
            <input type="submit" value="登录">
        </div>
    </form>
</div>
</body>
</html>
