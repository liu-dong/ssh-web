<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>账号列表</title>
</head>
<body>
<div class="search">
    账号：<input id="username"  type="text" placeholder="请输入">
    真实姓名：<input id="realName" type="text" placeholder="请输入">
    用户状态：<input id="userStatus" type="text" placeholder="请输入">
    <button id="searchBtn">搜索</button>
</div>

<table id="dataTable">
    <!-- 表格头部 -->
    <thead>
    <tr>
        <th>账号</th>
        <th>真实姓名</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>上传登录时间</th>
        <th>登录次数</th>
        <th>用户状态</th>
    </tr>
    </thead>
    <!-- 表格内容 -->
    <tbody>
    <!-- 这里会填充数据 -->
    </tbody>
</table>

<div class="pagination">
    <button id="prevPage">上一页</button>
    <span id="currentPage"></span>
    <button id="nextPage">下一页</button>
</div>
</body>
<script>
  // 模拟数据
  var currentPage = 1;
  var pageSize = 10;

  // 先显示第一页的数据
  displayData();

  document.getElementById('searchBtn').addEventListener('click', function() {
    var query1 = document.getElementById('query1').value;
    var query2 = document.getElementById('query2').value;
    var query3 = document.getElementById('query3').value;

    // 根据查询条件过滤数据
    // 你可能需要写一个更复杂的条件
    data = data.filter(item => item.yourField1 == query1 &&
      item.yourField2 == query2 &&
      item.yourField3 == query3);
    displayData();
  });

  document.getElementById('prevPage').addEventListener('click', function() {
    if (currentPage > 1) {
      currentPage--;
      displayData();
    }
  });

  document.getElementById('nextPage').addEventListener('click', function() {
    if (currentPage < Math.ceil(data.length / pageSize)) {
      currentPage++;
      displayData();
    }
  });

  function displayData() {
    var start = (currentPage - 1) * pageSize;
    var end = start + pageSize;
    var currentPageData = data.slice(start, end);

    var tbody = document.getElementById('dataTable').getElementsByTagName('tbody')[0];
    tbody.innerHTML = '';
    currentPageData.forEach(item => {
      let row = tbody.insertRow();
      for (let i = 0; i < 7; i++) {
      let cell = row.insertCell();
      cell.innerText = item[i];  // 根据你的数据结构获取值
    }
  });

    document.getElementById('currentPage').innerText = currentPage;
  }
</script>
</html>
