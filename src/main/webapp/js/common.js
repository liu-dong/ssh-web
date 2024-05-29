
/**
 *
 * @param url
 * @param params
 * @returns {HTMLFormElement}
 */
function postForm(url, params, target) {
  var temp = document.createElement("form"); //创建form表单
  temp.action = url;
  temp.target = target;
  temp.method = "post";
  temp.style.display = "none";//表单样式为隐藏
  for (var item in params) {//初始化表单内部的控件
    //根据实际情况创建不同的标签元素
    var opt = document.createElement("input");  //添加input标签
    opt.type = "text";   //类型为text
    opt.id = item;      //设置id属性
    opt.name = item;    //设置name属性
    opt.value = params[item];   //设置value属性
    temp.appendChild(opt);
  }
  document.body.appendChild(temp);
  temp.submit();
  temp.parentNode.removeChild(temp);
  return temp;
}

/**
 * 创建get表单
 * @param url
 * @param params
 * @returns {HTMLFormElement}
 */
function getForm(url, params) {
  var temp = document.createElement("form"); //创建form表单
  debugger
  temp.action = url;
  temp.method = "get";
  temp.style.display = "none";//表单样式为隐藏
  for (var item in params) {//初始化表单内部的控件
    //根据实际情况创建不同的标签元素
    var opt = document.createElement("input");  //添加input标签
    opt.type = "text";   //类型为text
    opt.id = item;      //设置id属性
    opt.name = item;    //设置name属性
    opt.value = params[item];   //设置value属性
    temp.appendChild(opt);
  }
  document.body.appendChild(temp);
  temp.submit();
  temp.parentNode.removeChild(temp);
  return temp;
}
