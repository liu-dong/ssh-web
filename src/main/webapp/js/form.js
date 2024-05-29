/**
 * 返回上一个页面
 */
function goBack() {
  window.history.back();
}

/**
 * 表单提交
 */
function submit() {
  document.getElementById('searchForm').submit()
}

/**
 * 翻页
 */
function turnPage(number) {
  var element = document.getElementById('currentPage');
  element.value = number;
  submit()
}

/**
 * 上一页
 */
function prevPage() {
  var element = document.getElementById('currentPage');
  var number = parseInt(element.value) - 1;
  if (number >= 1) {
    element.value = number;
    submit()
  } else {
    alert("已是第一页")
  }
}

/**
 * 下一页
 */
function nextPage() {
  var element = document.getElementById('currentPage');
  element.value = parseInt(element.value) + 1;
  submit()
}

function jump(url) {
  var element = parent.document.getElementById("contentFrame");
  if (!element) {
    console.error("无法找到iframe元素");
    return;
  }
  element.src = url;
}
