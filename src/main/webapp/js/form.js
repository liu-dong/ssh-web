/**
 * 返回上一个页面
 */
function goBack() {
  window.history.back();
}


/**
 * 详情页只读
 */
function detailReadonly() {
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
    if (submitButton) {
      submitButton.style.display = 'none';
    }
  }
}
