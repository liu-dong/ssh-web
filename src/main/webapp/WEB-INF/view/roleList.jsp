<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账号列表</title>
    <link rel="stylesheet" type="text/css" href="${_path}/css/list.css"/>
    <script type="text/javascript" src="${_path}/js/list.js"></script>
</head>
<body>
<div class="content-container">
    <h2>账号列表页</h2>
    <div class="search">
        <form id="searchForm" action="${path}/role/list" method="get">
            <input type="hidden" id="currentPage" name="page.page" value="${pageVO.currentPage}">
            <label for="username">角色名称：</label>
            <input id="username" name="dto.roleName" type="text" placeholder="请输入">
            <label for="realName">角色编码：</label>
            <input id="realName" name="dto.realCode" type="text" placeholder="请输入">

            <button type="submit">搜索</button>
        </form>
        <button onclick="jump('${_path}/navigate?module=role&type=detail')">新增</button>
    </div>
    <table id="dataTable">
        <thead>
        <tr>
            <th class="center width-50">序号</th>
            <th class="center width-200">角色编码</th>
            <th class="center width-200">角色名称</th>
            <th class="center">备注</th>
            <th class="center width-200">创建时间</th>
            <th class="center width-200">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="pageVO.dataList" status="stat">
            <tr>
                <td class="center width-50"><s:property value="#stat.index + 1"/></td>
                <td class="center width-200"><s:property value="roleCode"/></td>
                <td class="center width-200"><s:property value="roleName"/></td>
                <td class="center"><s:property value="remark"/></td>
                <td class="center width-200"><s:property value="createTime"/></td>
                <td class="center width-200">
                    <!-- 查看详情 -->
                    <a href="${_path}/role/detail?viewType=detail&roleId=<s:property value='id'/>">查看</a>
                    <!-- 编辑账号 -->
                    <a href="${_path}/role/detail?viewType=edit&roleId=<s:property value='id'/>">编辑</a>
                    <!-- 删除账号，建议使用 JavaScript -->
                    <a href="${_path}/role/delete?roleId=<s:property value='id'/>">删除</a>

                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div class="pagination">
        <button id="prevPage" onclick="turnPage(1)">首页</button>
        <button id="prevPage" onclick="prevPage()">上一页</button>
        <c:forEach begin="1" end="${pageVO.pageTotal}" var="i">
            <button onclick="turnPage(${i})">${i}</button>
        </c:forEach>
        <button id="nextPage" onclick="nextPage()">下一页</button>
        <span>共 ${pageVO.total} 条</span>
    </div>
</div>
</body>
<script>


</script>
</html>
