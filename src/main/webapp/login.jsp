<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<style>
    body {
        margin: 0; /* 移除默认的margin */
        width: 100vw; /* 视口宽度100% */
        height: 100vh; /* 视口高度100% */
        overflow: hidden; /* 确保没有滚动条 */
        box-sizing: border-box;
    }

    .container {
        width: 100%;
        height: 100%;
        /* background-image: url("images/backgroundImage.jpg"); */
        /* background-repeat: no-repeat; */
        /* background-position: center; */
        /* background-size: cover; !* 完全展示图片 *! */

        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    #loginForm {
        width: 50%;
        height: 50%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #loginForm div {
        font-size: 24px;
        width: 30%;
        display: flex;
        justify-content: space-between;
        margin: 10px 0;
    }

    .button {
        display: flex;
        justify-content: center;
    }
</style>
<body>
<div class="container">
    <h1>登录页面</h1>
    <form id="loginForm" action="login" method="post">
        <div>
            <label for="username">用户名:</label>
            <input type="text" name="username" id="username">
        </div>
        <div>
            <label for="password">密&nbsp;&nbsp;&nbsp;码:</label>
            <input type="password" name="password" id="password">
        </div>
        <div class="button">
            <input type="submit" value="登录">
        </div>
    </form>
</div>
</body>
</html>
