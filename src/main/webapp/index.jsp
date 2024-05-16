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
    }

    .header {
        height: 10%;
        display: flex;
    }

    .header-logo {
        width: 15%;
        background-image: url("images/logo.png");
        background-repeat: no-repeat;
        background-position: center;
        background-size: contain; /* 完全展示图片 */

    }
    .header-toolbar {
        width: 85%;
        display: flex;  /* 这个属性会让 .header-toolbar 成为flex的容器 */
        justify-content: flex-end;  /* 这会将子元素推向右边 */
        padding-right: 20px;
        font-size: 24px;

    }

    ul.nav-list {
        list-style: none; /* 移除默认的列表样式 */
        padding: 0;  /* 移除默认的内边距 */
        margin: 0;   /* 移除默认的外边距 */
        display: flex; /* 设置列表项为flexbox，使其可以排列在一行里 */

    }

    ul.nav-list li {
        padding: 0 10px; /* 添加左右内边距 */
        display: flex; /* 使用flex布局 */
        align-items: center; /* 垂直居中 */
        justify-content: center; /* 水平居中 */
    }

    ul.nav-list li:not(:last-child) {
        margin-right: 20px; /* 给li元素之间添加一些间隔但不包括最后一个元素 */
    }

    .main {
        display: flex;

        height: 90%;
    }

    .main .menu {
        width: 15%;
        font-size: 24px;
    }

    ul.menu-list {
        list-style: none; /* 移除默认的列表样式 */
        padding: 0;  /* 移除默认的内边距 */
        margin: 0;   /* 移除默认的外边距 */

    }

    ul.menu-list li {
        padding: 0 20px; /* 添加左右内边距 */
    }

    ul.menu-list li:not(:last-child) {
        margin: 20px 0; /* 给li元素之间添加一些间隔但不包括最后一个元素 */
    }

    ul.menu-list li ul {
        list-style: none; /* 移除默认的列表样式 */
        padding: 0;  /* 移除默认的内边距 */
        margin: 0;   /* 移除默认的外边距 */
    }
    ul.menu-list li ul li::before {
        content: "› "; /* 使用内容属性添加尖括号 */
        padding-right: 5px; /* 添加右侧间距以分隔尖括号和文本 */
    }
    ul.menu-list li ul li {
        padding: 0 20px; /* 添加左右内边距 */
    }

    ul.menu-list li ul li:not(:last-child) {
        margin: 10px 0; /* 给li元素之间添加一些间隔但不包括最后一个元素 */
    }

    /* 设置所有的子菜单 ul 为隐藏 */
    ul ul {
        display: none;
    }

    /* 鼠标滑过时，显示子菜单 */
    li:hover ul {
        display: block;
    }

    .main .main-container {
        width: 85%;
    }

    .main .main-container .content {
        padding: 5px;
        height: 95%;
    }
    .main .main-container .footer {
        height: 5%;
    }

    .footer {
        display: flex;
        justify-content: center;
        align-items: center;
    }

</style>
<body>
<div class="container">
    <div class="header">
        <div class="header-logo"></div>
        <div class="header-toolbar">
            <ul class="nav-list">
                <li>首页</li>
                <li>用户名</li>
                <li>头像</li>
                <li>修改密码</li>
                <li>退出</li>
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
                <h2>您好，世界！</h2>
            </div>
            <div class="footer">
                Copyright © 2024 LD
            </div>
        </div>
    </div>
</div>
</body>
</html>
