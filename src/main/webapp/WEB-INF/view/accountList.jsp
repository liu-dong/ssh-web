<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>账号列表</title>
    <link rel="stylesheet" type="text/css" href="css/list.css"/>
</head>
<body>
<div class="content-container">
    <div class="search">
        <label for="username">账号：</label><input id="username" type="text" placeholder="请输入">
        <label for="realName">真实姓名：</label><input id="realName" type="text" placeholder="请输入">
        <label for="userStatus">用户状态：</label><input id="userStatus" type="text" placeholder="请输入">
        <button type="submit">搜索</button>
        <button type="submit">新增</button>
    </div>

    <table id="dataTable">
        <!-- 表格头部 -->
        <thead>
        <tr>
            <th>序号</th>
            <th>账号</th>
            <th>真实姓名</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>上传登录时间</th>
            <th>登录次数</th>
            <th>用户状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <!-- 表格内容 -->
        <tbody>
        <!-- 这里会填充数据 -->
        <s:iterator value="pager.dataList" status="stat">
            <tr>
                <th><s:property value="#stat.index + 1"/></th>
                <th><s:property value="username"/></th>
                <th><s:property value="realName"/></th>
                <th><s:property value="phone"/></th>
                <th><s:property value="email"/></th>
                <th><s:property value="lastLoginTime"/></th>
                <th><s:property value="loginCount"/></th>
                <th><s:property value="userStatus"/></th>
                <th>
                    <button type="submit">查看</button>
                    <button type="submit">编辑</button>
                    <button type="submit">删除</button>
                </th>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <div class="pagination">
        <button id="prevPage">首页</button>
        <button id="prevPage">上一页</button>
        <s:iterator value="pager.pageTotal" status="stat">
            <span id="currentPage"><s:property value="#stat.index + 1"/></span>
        </s:iterator>
        <button id="nextPage">下一页</button>
    </div>
</div>

</body>
<script>

</script>
</html>
