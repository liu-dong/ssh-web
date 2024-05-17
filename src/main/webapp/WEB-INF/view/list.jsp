<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="search">
    <input id="query1" type="text" placeholder="查询条件1">
    <input id="query2" type="text" placeholder="查询条件2">
    <input id="query3" type="text" placeholder="查询条件3">
    <button id="searchBtn">搜索</button>
</div>

<table id="dataTable">
    <!-- 表格头部 -->
    <thead>
    <tr>
        <th>列1</th>
        <th>列2</th>
        <th>列3</th>
        <th>列4</th>
        <th>列5</th>
        <th>列6</th>
        <th>列7</th>
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
  let data = [...];  // 填充你的数据
  let currentPage = 1;
  const pageSize = 10;

  // 先显示第一页的数据
  displayData();

  document.getElementById('searchBtn').addEventListener('click', function() {
    const query1 = document.getElementById('query1').value;
    const query2 = document.getElementById('query2').value;
    const query3 = document.getElementById('query3').value;

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
    const start = (currentPage - 1) * pageSize;
    const end = start + pageSize;
    const currentPageData = data.slice(start, end);

    const tbody = document.getElementById('dataTable').getElementsByTagName('tbody')[0];
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
